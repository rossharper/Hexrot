package net.rossharper.collectionview.android;

import android.view.View;
import android.view.ViewGroup;

import net.rossharper.collectionview.ItemViewFactory;

public abstract class AndroidItemViewFactory implements ItemViewFactory<View, ViewGroup> {
    @Override
    public abstract View createView(ViewGroup parent);
}
