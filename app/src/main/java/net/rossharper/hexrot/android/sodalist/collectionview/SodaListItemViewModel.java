package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.ItemViewModel;

public class SodaListItemViewModel implements ItemViewModel {
    private String mProductName;

    public SodaListItemViewModel(String productName) {
        mProductName = productName;
    }

    public String getProductName() {
        return mProductName;
    }
}
