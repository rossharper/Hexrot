package net.rossharper.collectionview.android.ListView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.rossharper.collectionview.CollectionModel;
import net.rossharper.collectionview.android.AndroidItemViewFactory;

import java.util.Collections;

public class Adapter extends BaseAdapter {

    private CollectionModel mCollectionModel = new CollectionModel(Collections.EMPTY_LIST);

    public void setCollectionModel(CollectionModel collectionModel) {
        mCollectionModel = collectionModel;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCollectionModel.getCount();
    }

    @Override
    public Object getItem(int i) {
        return mCollectionModel.getItemModel(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // TODO: hmm type safety? better way?
        // casting the view factory here, then unchecked call to bind.

        if(view == null) {
            view = ((AndroidItemViewFactory)mCollectionModel.getItemModel(i).getItemViewFactory()).createView(viewGroup);
        }

        mCollectionModel.getItemModel(i).getItemViewBinder().bind(view, mCollectionModel.getItemModel(i).getItemViewModel());

        return view;
    }
}
