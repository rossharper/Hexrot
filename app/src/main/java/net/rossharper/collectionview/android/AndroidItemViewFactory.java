package net.rossharper.collectionview.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class AndroidItemViewFactory implements ItemViewFactory<View, ViewGroup> {

    protected Context mContext;

    public AndroidItemViewFactory(Context context) {
        mContext = context;
    }

    @Override
    public abstract View createView(ViewGroup parent);
}
