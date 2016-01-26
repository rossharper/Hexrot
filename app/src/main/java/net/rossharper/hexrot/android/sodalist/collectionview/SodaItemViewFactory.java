package net.rossharper.hexrot.android.sodalist.collectionview;

import android.view.View;
import android.view.ViewGroup;

import net.rossharper.collectionview.android.AndroidItemViewFactory;
import net.rossharper.hexrot.android.sodalist.AndroidSodaItemView;

public class SodaItemViewFactory extends AndroidItemViewFactory {
    @Override
    public View createView(ViewGroup parent) {
        return AndroidSodaItemView.inflate(parent);
    }
}
