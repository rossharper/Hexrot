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

        ItemViewFactory itemViewFactory = new SodaItemViewFactory();
        SodaDetailsScreenDisplayCommandFactory screenDisplayCommandFactory =
                new SodaDetailsScreenDisplayCommandFactory(mScreenManager);

        for(final Soda soda : sodaList.getAsList()) {

            final ScreenDisplayCommand screenDisplayCommand = screenDisplayCommandFactory.createWithData(soda);
            ItemViewBinder itemViewBinder = new SodaItemViewBinder(new ClickListener() {
                @Override
                public void onClick() {
                    screenDisplayCommand.displayScreen();
                }
            });
            ItemViewModel itemViewModel = new SodaListItemViewModel(soda.getName());
            itemModels.add(new ItemModel(itemViewFactory, itemViewBinder, itemViewModel));
        }

        return new CollectionModel(itemModels);
    }
}
