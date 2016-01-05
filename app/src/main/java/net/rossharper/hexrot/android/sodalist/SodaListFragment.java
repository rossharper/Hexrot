package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.app.AppConfig;
import net.rossharper.hexrot.android.network.OkHttpNetworkingFactory;
import net.rossharper.hexrot.android.sodadetails.AndroidSodaDetailsScreenDisplayEventFactory;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodalist.SodaListController;
import net.rossharper.hexrot.sodalist.SodaListView;
import net.rossharper.hexrot.sodaprovider.SodaListProviderConfig;
import net.rossharper.hexrot.sodaprovider.SodaListProviderFactory;

public class SodaListFragment extends Fragment implements SodaListView {
    private SodaListController mController;

    private ListView mListView;
    private SodaListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soda_list_fragment, container, false);

        // TODO: create some sort of streamview that is abstracted from Android somewhat
        // uses recyclerview under the hood (Android Implementation)
        // data adapter from model to view model
        // view binders: view model bound onto views (cells)
        setupListView(view);

        return view;
    }

    private void setupListView(View view) {
        mListView = (ListView)view.findViewById(R.id.listView);
        mListAdapter = new SodaListAdapter(getActivity());
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mController.onItemClick(position);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        SodaListProviderConfig config = new SodaListProviderConfig() {
            @Override
            public String getSodaListUrl() {
                return AppConfig.SODA_LIST_URL;
            }
        };

        final SodaListProviderFactory sodaListProviderFactory = new SodaListProviderFactory();
        mController = new SodaListController(
                this,
                sodaListProviderFactory.createSodaListProvider(new OkHttpNetworkingFactory(getActivity()), config),
                new AndroidSodaDetailsScreenDisplayEventFactory());
        mController.onReady();
    }

    @Override
    public void displaySodaList(SodaList sodaList) {
        mListAdapter.setSodaList(sodaList);
    }

    @Override
    public void displaySodaListFetchError() {
        Toast.makeText(getActivity(), R.string.soda_list_fetch_error, Toast.LENGTH_LONG).show();
    }
}
