package net.rossharper.hexrot.sodaprovider;

import net.rossharper.hexrot.sodalist.SodaList;

public interface SodaListProviderListener {
    void sodaListReceived(SodaList sodaList);
    void sodaListFetchError();
}
