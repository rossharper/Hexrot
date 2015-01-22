package net.rossharper.hexrot.android.sodalist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.sodalist.SodaListController;
import net.rossharper.hexrot.sodalist.SodaListView;

public class SodaListFragment extends Fragment implements SodaListView {
    private SodaListController mController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.soda_list_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        mController = new SodaListController(this);
        mController.onReady();
    }
}
