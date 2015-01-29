package net.rossharper.hexrot.android.sodadetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.model.Soda;

public class SodaDetailsFragment extends Fragment {
    public static final String SODA_ARG = "soda";

    public SodaDetailsFragment() {
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);

        // TODO: do something with the arguments!
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soda_details_fragment, container, false);
        return view;
    }
}
