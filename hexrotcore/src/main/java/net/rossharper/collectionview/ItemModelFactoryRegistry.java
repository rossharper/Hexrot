package net.rossharper.collectionview;

import java.util.HashMap;

public class ItemModelFactoryRegistry {

    interface DataKeyProvider {
        String getKeyForData(Object data);
    }

    class DataTypeDataKeyProvider implements DataKeyProvider {
        @Override
        public String getKeyForData(Object data) {
            return data.getClass().toString();
        }
    }

    private HashMap<Class, DataKeyProvider> mMapKeyProviders = new HashMap<Class, DataKeyProvider>();
    private HashMap<String, ItemModelFactory> mItemModelFactoryMap = new HashMap<String, ItemModelFactory>();

    public void registerMapKeyProvider(Class dataType, DataKeyProvider dataKeyProvider) {
        mMapKeyProviders.put(dataType, dataKeyProvider);
    }

    public void registerItemModelFactory(Class dataClass, ItemModelFactory itemModelFactory) {
        DataKeyProvider dataKeyProvider = new DataTypeDataKeyProvider();
        registerMapKeyProvider(dataClass, dataKeyProvider);
        registerItemModelFactory(dataClass.toString(), itemModelFactory);
    }

    public void registerItemModelFactory(String key, ItemModelFactory itemModelFactory) {
        mItemModelFactoryMap.put(key, itemModelFactory);
    }

    public ItemModelFactory factoryForData(Object data) {
        ItemModelFactory itemModelFactory = null;

        DataKeyProvider dataKeyProvider = getMapKeyProviderForData(data);
        if(dataKeyProvider != null) {
            itemModelFactory = getItemModelFactoryForKey(dataKeyProvider.getKeyForData(data));
        }

        return itemModelFactory;
    }

    private ItemModelFactory getItemModelFactoryForKey(String key) {
        return mItemModelFactoryMap.get(key);
    }

    private DataKeyProvider getMapKeyProviderForData(Object data) {
        return mMapKeyProviders.get(data.getClass());
    }
}
