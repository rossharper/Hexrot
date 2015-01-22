package net.rossharper.hexrot.android.sodalist;

import net.rossharper.hexrot.sodalist.SodaListProvider;
import net.rossharper.hexrot.sodalist.SodaListProviderListener;

public class RemoteSodaListProvider implements SodaListProvider {
    @Override
    public void getSodas(SodaListProviderListener sodaListProviderListener) {
        new GithubSodaListFetcher().getSodas();
    }
}
