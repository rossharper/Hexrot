package net.rossharper.hexrot.android.sodadetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodadetails.SodaDetailsController;
import net.rossharper.hexrot.sodadetails.SodaDetailsView;

public class SodaDetailsFragment extends Fragment implements SodaDetailsView {
    public static final String SODA_ARG = "soda";
    private SodaDetailsController mSodaDetailsController;

    public SodaDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.soda_details_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        mSodaDetailsController = new SodaDetailsController(this, getDataFromBundleArguments());
        mSodaDetailsController.onReady();
    }

    private Soda getDataFromBundleArguments() {
        // TODO: a view model for this? instead of a datamodel? Or would they be the same!?
        return ((SodaParcel)getArguments().getParcelable(SODA_ARG)).getSoda();
    }

    @Override
    public void setSodaName(String sodaName) {
        setTextView(R.id.sodaname, sodaName);
    }

    @Override
    public void setSodaPrice(String sodaPrice) {
        setTextView(R.id.sodaprice, sodaPrice);
    }

    @Override
    public void setSodaVolume(String sodaVolume) {
        setTextView(R.id.sodavolume, sodaVolume);
    }

    private void setTextView(int textViewId, String text) {
        ((TextView)getView().findViewById(textViewId)).setText(text);
    }
}
