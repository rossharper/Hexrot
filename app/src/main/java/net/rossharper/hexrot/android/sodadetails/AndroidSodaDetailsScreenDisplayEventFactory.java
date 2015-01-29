package net.rossharper.hexrot.android.sodadetails;

import net.rossharper.hexrot.android.NavigationBus;
import net.rossharper.hexrot.android.ScreenDisplayEvent;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayEventFactory;

public class AndroidSodaDetailsScreenDisplayEventFactory implements SodaDetailsScreenDisplayEventFactory {
    @Override
    public void emitDisplayScreenEvent(Soda soda) {
        NavigationBus.getInstance().post(new ScreenDisplayEvent(new SodaDetailsScreenFactory(soda)));
    }
}
