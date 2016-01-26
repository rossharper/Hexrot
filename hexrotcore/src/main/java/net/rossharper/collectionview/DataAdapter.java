package net.rossharper.collectionview;

public interface DataAdapter<DataType, ViewModelType extends ItemViewModel> {
    ViewModelType createViewModel(DataType data);
}
