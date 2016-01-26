package net.rossharper.collectionview;

import net.rossharper.collectionview.CollectionModel;

public interface CollectionModelFactory<DataType> {
    CollectionModel createCollectionModel(DataType data);
}
