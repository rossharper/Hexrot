package net.rossharper.collectionview.android;

import net.rossharper.collectionview.ItemViewModel;

public class ItemModel {
    private ItemViewFactory mItemViewFactory;
    private ItemViewBinder mItemViewBinder;
    private ItemViewModel mItemViewModel;

    public ItemModel(ItemViewFactory itemViewFactory, ItemViewBinder itemViewBinder, ItemViewModel itemViewModel) {
        mItemViewFactory = itemViewFactory;
        mItemViewBinder = itemViewBinder;
        mItemViewModel = itemViewModel;
    }

    public ItemViewFactory getItemViewFactory() {
        return mItemViewFactory;
    }

    public ItemViewBinder getItemViewBinder() {
        return mItemViewBinder;
    }

    public ItemViewModel getItemViewModel() {
        return mItemViewModel;
    }
}
