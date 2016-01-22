package net.rossharper.hexrot.android.sodalist.collectionview;

import net.rossharper.collectionview.android.ItemViewBinder;
import net.rossharper.hexrot.android.sodalist.SodaItemView;

public class SodaItemViewBinder implements ItemViewBinder<SodaItemView, SodaListItemViewModel> {
    @Override
    public void bind(SodaItemView view, SodaListItemViewModel itemViewModel) {
        view.setProductName(itemViewModel.getProductName());
    }
}
