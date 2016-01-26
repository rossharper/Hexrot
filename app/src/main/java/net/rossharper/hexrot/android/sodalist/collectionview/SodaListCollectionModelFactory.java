package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.ItemViewModel;
import net.rossharper.collectionview.ClickListener;
import net.rossharper.collectionview.CollectionModel;
import net.rossharper.collectionview.CollectionModelFactory;
import net.rossharper.collectionview.ItemModel;
import net.rossharper.collectionview.ItemViewBinder;
import net.rossharper.collectionview.ItemViewFactory;
import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;
import net.rossharper.hexrot.android.sodadetails.SodaDetailsScreenDisplayCommandFactory;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodalist.SodaList;

import java.util.ArrayList;

public class SodaListCollectionModelFactory implements CollectionModelFactory<SodaList> {
    private ScreenManager mScreenManager;

    public SodaListCollectionModelFactory(ScreenManager screenManager) {
        mScreenManager = screenManager;
    }

    @Override
    public CollectionModel createCollectionModel(SodaList sodaList) {

        // TODO: factoryise this stuff. abstract types around data adapters for model conversion.

        ArrayList<ItemModel> itemModels = new ArrayList<ItemModel>();

        final SodaDetailsScreenDisplayCommandFactory screenDisplayCommandFactory =
                new SodaDetailsScreenDisplayCommandFactory(mScreenManager);

        ClickListenerFactory<Soda> clickListenerFactory = new ClickListenerFactory<Soda>() {
            @Override
            public ClickListener createClickListener(Soda data) {
                final ScreenDisplayCommand screenDisplayCommand = screenDisplayCommandFactory.createWithData(data);
                return new ClickListener() {
                    @Override
                    public void onClick() {
                        screenDisplayCommand.displayScreen();
                    }
                };
            }
        };

        SodaListItemModelFactory itemModelFactory = new SodaListItemModelFactory(clickListenerFactory);

        // TODO: some sort of default modeladapter
        for(final Soda soda : sodaList.getAsList()) {
            itemModels.add(itemModelFactory.createItemModel(soda));
        }

        return new CollectionModel(itemModels);
    }

    // TODO: pull out somewhere
    interface ClickListenerFactory<DataType> {
        ClickListener createClickListener(DataType data);
    }

    // TODO: abstraction for this?
    class SodaListItemModelFactory {
        private SodaListItemDataAdapter mDataAdapter = new SodaListItemDataAdapter();
        private ItemViewFactory mItemViewFactory = new SodaItemViewFactory();
        private ClickListenerFactory<Soda> mClickListenerFactory;

        SodaListItemModelFactory(ClickListenerFactory<Soda> clickListenerFactory) {
            mClickListenerFactory = clickListenerFactory;
        }

        public ItemModel createItemModel(Soda data) {

            ItemViewBinder itemViewBinder = new SodaItemViewBinder(mClickListenerFactory.createClickListener(data));
            ItemViewModel itemViewModel = mDataAdapter.createViewModel(data);

            return new ItemModel(mItemViewFactory, itemViewBinder, itemViewModel);
        }
    }
}
