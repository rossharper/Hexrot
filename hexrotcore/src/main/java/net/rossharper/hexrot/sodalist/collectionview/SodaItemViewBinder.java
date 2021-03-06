package net.rossharper.hexrot.sodalist.collectionview;

import net.rossharper.collectionview.ClickListener;
import net.rossharper.collectionview.ItemViewBinder;
import net.rossharper.hexrot.sodalist.SodaItemView;

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
