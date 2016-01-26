package net.rossharper.collectionview;

import java.util.List;

public interface DataProviderListener {
    void onLoad(List<?> data);
    void onError();
}
