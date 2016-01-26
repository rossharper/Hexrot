package net.rossharper.hexrot.android.sodalist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.rossharper.collectionview.ClickListener;
import net.rossharper.hexrot.R;

public class AndroidSodaItemView extends LinearLayout implements SodaItemView {

    private TextView mProductNameLabel;

    public AndroidSodaItemView(Context context) {
        super(context);
        setupChildren();
    }

    public AndroidSodaItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupChildren();
    }

    public AndroidSodaItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupChildren();
    }

    public static AndroidSodaItemView inflate(ViewGroup parent) {
        return (AndroidSodaItemView) LayoutInflater.from(parent.getContext()).inflate(R.layout.soda_item_view, parent, false);
    }

    private void setupChildren() {
        LayoutInflater.from(getContext()).inflate(R.layout.soda_item_view_children, this, true);
        mProductNameLabel = (TextView)findViewById(R.id.sodaname);
    }

    @Override
    public void setClickListener(final ClickListener clickListener) {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick();
            }
        });
    }

    @Override
    public void setProductName(final String productName) {
        mProductNameLabel.setText(productName);
    }
}
