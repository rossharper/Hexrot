package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.ClickListenerFactory;
import net.rossharper.collectionview.ItemModelFactory;
import net.rossharper.collectionview.ClickListener;
import net.rossharper.collectionview.CollectionModel;
import net.rossharper.collectionview.CollectionModelFactory;
import net.rossharper.collectionview.ItemModel;
import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;
import net.rossharper.hexrot.android.sodadetails.SodaDetailsScreenDisplayCommandFactory;
import net.rossharper.hexrot.model.Soda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SodaListCollectionModelFactory implements CollectionModelFactory {
    private final ItemMapCollectionModelFactory mCollectionModelFactory;

    public SodaListCollectionModelFactory(ScreenManager screenManager) {

        final SodaDetailsScreenDisplayCommandFactory screenDisplayCommandFactory =
                new SodaDetailsScreenDisplayCommandFactory(screenManager);

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

        ItemModelFactory itemModelFactory = new SodaListItemModelFactory(clickListenerFactory);

        ItemModelFactoryMap itemModelFactoryMap = new ItemModelFactoryMap();
        itemModelFactoryMap.registerItemModelFactory(Soda.class, itemModelFactory);

        mCollectionModelFactory = new ItemMapCollectionModelFactory(itemModelFactoryMap);
    }

    @Override
    public CollectionModel createCollectionModel(List<?> data) {
        return mCollectionModelFactory.createCollectionModel(data);
    }

    class ItemMapCollectionModelFactory implements CollectionModelFactory {

        private ItemModelFactoryMap mItemModelFactoryMap;

        ItemMapCollectionModelFactory(ItemModelFactoryMap itemModelFactoryMap) {
            mItemModelFactoryMap = itemModelFactoryMap;
        }

        @Override
        public CollectionModel createCollectionModel(List<?> data) {
            ArrayList<ItemModel> itemModels = new ArrayList<ItemModel>();

            for(final Object dataItem : data) {
                ItemModelFactory itemModelFactory = mItemModelFactoryMap.factoryForData(dataItem);
                itemModels.add(itemModelFactory.createItemModel(dataItem));
            }

            return new CollectionModel(itemModels);
        }
    }

    interface MapKeyProvider {
        String getKeyForData(Object data);
    }

    class DataTypeMapKeyProvider implements MapKeyProvider {
        @Override
        public String getKeyForData(Object data) {
            return data.getClass().toString();
        }
    }

    class ItemModelFactoryMap {
        HashMap<Class, MapKeyProvider> mMapKeyProviders = new HashMap<Class, MapKeyProvider>();
        HashMap<String, ItemModelFactory> mItemModelFactoryMap = new HashMap<String, ItemModelFactory>();

        void registerMapKeyProvider(Class dataType, MapKeyProvider mapKeyProvider) {
            mMapKeyProviders.put(dataType, mapKeyProvider);
        }

        void registerItemModelFactory(Class dataClass, ItemModelFactory itemModelFactory) {
            MapKeyProvider mapKeyProvider = new DataTypeMapKeyProvider();
            registerMapKeyProvider(dataClass, mapKeyProvider);
            registerItemModelFactory(dataClass.toString(), itemModelFactory);
        }

        void registerItemModelFactory(String key, ItemModelFactory itemModelFactory) {
            mItemModelFactoryMap.put(key, itemModelFactory);
        }

        ItemModelFactory factoryForData(Object data) {
            ItemModelFactory itemModelFactory = null;

            MapKeyProvider mapKeyProvider = getMapKeyProviderForData(data);
            if(mapKeyProvider != null) {
                itemModelFactory = getItemModelFactoryForKey(mapKeyProvider.getKeyForData(data));
            }

            return itemModelFactory;
        }

        private ItemModelFactory getItemModelFactoryForKey(String key) {
            return mItemModelFactoryMap.get(key);
        }

        private MapKeyProvider getMapKeyProviderForData(Object data) {
            return mMapKeyProviders.get(data.getClass());
        }
    }
}
