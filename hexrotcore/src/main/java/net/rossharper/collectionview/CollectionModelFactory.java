package net.rossharper.collectionview;

import java.util.List;

public interface CollectionModelFactory {
    CollectionModel createCollectionModel(List<?> data);
}
