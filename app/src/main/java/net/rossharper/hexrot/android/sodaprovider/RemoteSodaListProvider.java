package net.rossharper.hexrot.android.sodaprovider;

import android.content.Context;
import android.os.Handler;

import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;

import org.json.JSONException;

public class RemoteSodaListProvider implements SodaListProvider {
    private final Handler mMainThreadHandler;

    public RemoteSodaListProvider(Context context) {
        mMainThreadHandler = new Handler(context.getMainLooper());
    }

    @Override
    public void getSodas(final SodaListProviderListener sodaListProviderListener) {
        new GithubJsonSodaListFetcher().getSodas(new GithubJsonSodaListFetcher.Listener() {
            @Override
            public void sodasReceived(String jsonSodaList) {
                try {
                    final SodaList sodaList = new SodaJsonParser().parse(jsonSodaList);
                    mMainThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            sodaListProviderListener.sodaListReceived(sodaList);
                        }
                    });
                } catch (JSONException e) {
                    // TODO: error handling
                }
            }
        });
    }
}
