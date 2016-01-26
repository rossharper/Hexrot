package net.rossharper.hexrot.sodalist.collectionview;

import net.rossharper.collectionview.DataAdapter;
import net.rossharper.hexrot.model.Soda;

class SodaListItemDataAdapter implements DataAdapter<Soda, SodaListItemViewModel> {
    @Override
    public SodaListItemViewModel createViewModel(Soda data) {
        return new SodaListItemViewModel(data.getName());
    }
}
