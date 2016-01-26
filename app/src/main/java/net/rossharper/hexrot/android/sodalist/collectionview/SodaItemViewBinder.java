package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.android.ClickListener;
import net.rossharper.collectionview.android.ItemViewBinder;
import net.rossharper.hexrot.android.sodalist.SodaItemView;

public class SodaItemViewBinder implements ItemViewBinder<SodaItemView, SodaListItemViewModel> {
    private ClickListener mClickListener;

    public SodaItemViewBinder(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public void bind(SodaItemView view, SodaListItemViewModel itemViewModel) {
        view.setClickListener(mClickListener);
        view.setProductName(itemViewModel.getProductName());
    }
}
