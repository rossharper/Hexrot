package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.ClickListenerFactory;
import net.rossharper.collectionview.ItemModelFactory;
import net.rossharper.collectionview.ClickListener;
import net.rossharper.collectionview.CollectionModelDataAdapter;
import net.rossharper.collectionview.ItemModelFactoryRegistry;
import net.rossharper.collectionview.RegistryCollectionModelDataAdapter;
import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.android.screenmanager.ScreenManager;
import net.rossharper.hexrot.android.sodadetails.SodaDetailsScreenDisplayCommandFactory;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodalist.collectionview.SodaListItemModelFactory;

public class SodaListCollectionModelDataAdapterFactory {
    public static CollectionModelDataAdapter createCollectionModelDataAdapter(ScreenManager screenManager) {

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

        ItemModelFactory itemModelFactory = new SodaListItemModelFactory(clickListenerFactory, new SodaItemViewFactory());

        ItemModelFactoryRegistry itemModelFactoryRegistry = new ItemModelFactoryRegistry();
        itemModelFactoryRegistry.registerItemModelFactory(Soda.class, itemModelFactory);

        return new RegistryCollectionModelDataAdapter(itemModelFactoryRegistry);
    }
}
