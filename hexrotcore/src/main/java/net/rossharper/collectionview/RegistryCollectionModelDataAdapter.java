package net.rossharper.collectionview;

import java.util.ArrayList;
import java.util.List;

public class RegistryCollectionModelDataAdapter implements CollectionModelDataAdapter {

    private ItemModelFactoryRegistry mItemModelFactoryRegistry;

    public RegistryCollectionModelDataAdapter(ItemModelFactoryRegistry itemModelFactoryRegistry) {
        mItemModelFactoryRegistry = itemModelFactoryRegistry;
    }

    @Override
    public CollectionModel createCollectionModel(List<?> data) {
        ArrayList<ItemModel> itemModels = new ArrayList<ItemModel>();

        for(final Object dataItem : data) {
            ItemModelFactory itemModelFactory = mItemModelFactoryRegistry.factoryForData(dataItem);
            itemModels.add(itemModelFactory.createItemModel(dataItem));
        }

        return new CollectionModel(itemModels);
    }
}
