package net.rossharper.collectionview;

import java.util.List;

public class CollectionModel {

    private final List<ItemModel> mItemModels;

    public CollectionModel(List<ItemModel> itemModels) {
        mItemModels = itemModels;
    }

    public int getCount() {
        return mItemModels.size();
    }

    public ItemModel getItemModel(int position) {
        return mItemModels.get(position);
    }
}
