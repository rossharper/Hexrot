package net.rossharper.hexrot.sodalist.collectionview;

import net.rossharper.collectionview.ClickListenerFactory;
import net.rossharper.collectionview.ItemModel;
import net.rossharper.collectionview.ItemModelFactory;
import net.rossharper.collectionview.ItemViewBinder;
import net.rossharper.collectionview.ItemViewFactory;
import net.rossharper.collectionview.ItemViewModel;
import net.rossharper.hexrot.model.Soda;

public class SodaListItemModelFactory implements ItemModelFactory {
    private SodaListItemDataAdapter mDataAdapter = new SodaListItemDataAdapter();
    private ItemViewFactory mItemViewFactory;
    private ClickListenerFactory<Soda> mClickListenerFactory;

    public SodaListItemModelFactory(ClickListenerFactory<Soda> clickListenerFactory, ItemViewFactory sodaItemViewFactory) {
        mClickListenerFactory = clickListenerFactory;
        mItemViewFactory = sodaItemViewFactory;
    }

    public ItemModel createItemModel(Object data) {
        // TODO: how to do away with this cast using generics?
        Soda soda = (Soda)data;

        ItemViewBinder itemViewBinder = new SodaItemViewBinder(mClickListenerFactory.createClickListener(soda));
        ItemViewModel itemViewModel = mDataAdapter.createViewModel(soda);

        return new ItemModel(mItemViewFactory, itemViewBinder, itemViewModel);
    }
}
