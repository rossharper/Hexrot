package net.rossharper.hexrot.sodadetails;

import net.rossharper.hexrot.ScreenDisplayCommand;
import net.rossharper.hexrot.model.Soda;

public interface SodaDetailsScreenDisplayCommandFactory {
    ScreenDisplayCommand createWithData(Soda soda);
}
