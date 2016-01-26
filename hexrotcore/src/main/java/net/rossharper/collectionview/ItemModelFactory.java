package net.rossharper.collectionview;

public interface ItemModelFactory<DataType> {
    ItemModel createItemModel(DataType data);
}
