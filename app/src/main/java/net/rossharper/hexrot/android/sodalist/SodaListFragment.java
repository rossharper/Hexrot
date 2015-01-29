package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodalist.SodaListController;
import net.rossharper.hexrot.sodalist.SodaListProvider;
import net.rossharper.hexrot.sodalist.SodaListProviderListener;
import net.rossharper.hexrot.sodalist.SodaListView;

public class SodaListFragment extends Fragment implements SodaListView {
    private SodaListController mController;

    private ListView mListView;
    private SodaListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soda_list_fragment, container, false);
        setupListView(view);
        return view;
    }

    private void setupListView(View view) {
        mListView = (ListView)view.findViewById(R.id.listView);
        mListAdapter = new SodaListAdapter(getActivity());
        mListView.setAdapter(mListAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        mController = new SodaListController(this, new RemoteSodaListProvider(getActivity()));
        mController.onReady();
    }

    @Override
    public void displaySodaList(SodaList sodaList) {
        mListAdapter.setSodaList(sodaList);
    }
}
