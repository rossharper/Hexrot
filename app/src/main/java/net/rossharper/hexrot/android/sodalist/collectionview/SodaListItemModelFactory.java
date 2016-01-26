package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.ClickListenerFactory;
import net.rossharper.collectionview.ItemModel;
import net.rossharper.collectionview.ItemModelFactory;
import net.rossharper.collectionview.ItemViewBinder;
import net.rossharper.collectionview.ItemViewFactory;
import net.rossharper.collectionview.ItemViewModel;
import net.rossharper.hexrot.model.Soda;

class SodaListItemModelFactory implements ItemModelFactory<Soda> {
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
