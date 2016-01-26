package net.rossharper.collectionview;

public interface ItemViewFactory<ViewType, ParentViewType> {
    ViewType createView(ParentViewType parent);
}
