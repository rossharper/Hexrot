package net.rossharper.collectionview.android;

import android.view.View;

import net.rossharper.collectionview.ItemViewModel;

public interface ItemViewBinder<ViewType, ViewModelType extends ItemViewModel> {
    void bind(ViewType view, ViewModelType itemViewModel);
}
