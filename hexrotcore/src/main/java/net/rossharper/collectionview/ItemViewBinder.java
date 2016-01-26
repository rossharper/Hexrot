package net.rossharper.collectionview;

import net.rossharper.collectionview.ItemViewModel;

public interface ItemViewBinder<ViewType, ViewModelType extends ItemViewModel> {
    void bind(ViewType view, ViewModelType itemViewModel);
}
