package net.rossharper.hexrot.android.sodalist;

import net.rossharper.collectionview.ClickListener;

public interface SodaItemView {
    void setClickListener(final ClickListener clickListener);
    void setProductName(final String productName);
}
