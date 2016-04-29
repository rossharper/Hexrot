package net.rossharper.collectionview.android.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import net.rossharper.collectionview.CollectionModel;
import net.rossharper.collectionview.CollectionView;
import net.rossharper.hexrot.R;
import net.rossharper.hexrot.android.app.SingleActivityApplication;

// TODO: when multiple implementations we just want a "CollectionView" that can be included in XML
// the actual underlying ListView or CollectionView could be merged in perhaps
public class ListViewCollectionView extends FrameLayout implements CollectionView {
    private Adapter mListAdapter;

    public ListViewCollectionView(Context context) {
        super(context);
        initialise();
    }

    public ListViewCollectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise();
    }

    public ListViewCollectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise();
    }

    private void initialise() {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.list_view_collection_view, this);

        mListAdapter = new Adapter();
        ((ListView)root.findViewById(R.id.listView)).setAdapter(mListAdapter);
    }

    @Override
    public void setCollectionModel(final CollectionModel collectionModel) {
        this.post(new Runnable() {
            @Override
            public void run() {
                mListAdapter.setCollectionModel(collectionModel);
            }
        });
    }
}
