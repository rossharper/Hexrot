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
                    invokeOnMainThread(new SodaListReceived(sodaListProviderListener, sodaList));
                } catch (JSONException e) {
                    // TODO: error handling
                }
            }

            @Override
            public void sodaFetchError() {
                invokeOnMainThread(new SodaListFetchError(sodaListProviderListener));
            }
        });
    }

    private void invokeOnMainThread(final Response response) {
        mMainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                response.invoke();
            }
        });
    }

    private interface Response {
        void invoke();
    }

    private class SodaListReceived implements Response {
        private SodaListProviderListener mSodaListProviderListener;
        private SodaList mSodaList;

        public SodaListReceived(SodaListProviderListener sodaListProviderListener, SodaList sodaList) {
            mSodaListProviderListener = sodaListProviderListener;
            mSodaList = sodaList;
        }

        @Override
        public void invoke() {
            mSodaListProviderListener.sodaListReceived(mSodaList);
        }
    }

    private class SodaListFetchError implements Response {
        private SodaListProviderListener mSodaListProviderListener;

        private SodaListFetchError(SodaListProviderListener sodaListProviderListener) {
            mSodaListProviderListener = sodaListProviderListener;
        }

        @Override
        public void invoke() {
            mSodaListProviderListener.sodaListFetchError();
        }
    }
}
