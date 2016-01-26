package net.rossharper.collectionview;

import java.util.List;

public interface CollectionModelDataAdapter {
    CollectionModel createCollectionModel(List<?> data);
}
