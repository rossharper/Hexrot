package net.rossharper.hexrot.sodalist.collectionview;

import net.rossharper.collectionview.ClickListenerFactory;
import net.rossharper.collectionview.ItemModelFactory;
import net.rossharper.collectionview.ClickListener;
import net.rossharper.collectionview.CollectionModelDataAdapter;
import net.rossharper.collectionview.ItemModelFactoryRegistry;
import net.rossharper.collectionview.ItemViewFactory;
import net.rossharper.collectionview.RegistryCollectionModelDataAdapter;
import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayCommandFactory;

public class SodaListCollectionModelDataAdapterFactory {
    public static CollectionModelDataAdapter createCollectionModelDataAdapter(
            final SodaDetailsScreenDisplayCommandFactory detailsScreenDisplayCommandFactory,
            ItemViewFactory sodaItemViewFactory) {
        ClickListenerFactory<Soda> clickListenerFactory = new ClickListenerFactory<Soda>() {
            @Override
            public ClickListener createClickListener(Soda data) {
                final ScreenDisplayCommand screenDisplayCommand = detailsScreenDisplayCommandFactory.createWithData(data);
                return new ClickListener() {
                    @Override
                    public void onClick() {
                        screenDisplayCommand.displayScreen();
                    }
                };
            }
        };

        ItemModelFactory itemModelFactory = new SodaListItemModelFactory(clickListenerFactory, sodaItemViewFactory);

        ItemModelFactoryRegistry itemModelFactoryRegistry = new ItemModelFactoryRegistry();
        itemModelFactoryRegistry.registerItemModelFactory(Soda.class, itemModelFactory);

        return new RegistryCollectionModelDataAdapter(itemModelFactoryRegistry);
    }
}
