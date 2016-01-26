package net.rossharper.collectionview.android;

public interface CollectionModelFactory<DataType> {
    CollectionModel createCollectionModel(DataType data);
}
