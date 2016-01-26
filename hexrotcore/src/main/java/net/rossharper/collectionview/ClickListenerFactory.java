package net.rossharper.collectionview;

public interface ClickListenerFactory<DataType> {
    ClickListener createClickListener(DataType data);
}
