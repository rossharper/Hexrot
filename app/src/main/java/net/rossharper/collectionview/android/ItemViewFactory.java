package net.rossharper.collectionview.android;

public interface ItemViewFactory<ViewType, ParentViewType> {
    ViewType createView(ParentViewType parent);
}
