package net.rossharper.hexrot.android.sodadetails;

import net.rossharper.hexrot.android.NavigationBus;
import net.rossharper.hexrot.android.StackedScreenDisplayEvent;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayEventFactory;

public class AndroidSodaDetailsScreenDisplayEventFactory implements SodaDetailsScreenDisplayEventFactory {
    @Override
    public void emitDisplayScreenEvent(Soda soda) {
        NavigationBus.getEventBus().post(new StackedScreenDisplayEvent(new SodaDetailsScreenFactory(soda)));
    }
}
