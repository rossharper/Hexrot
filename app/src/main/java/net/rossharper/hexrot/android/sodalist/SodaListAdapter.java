package net.rossharper.hexrot.android.sodalist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.rossharper.hexrot.R;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.sodalist.SodaList;

public class SodaListAdapter extends ArrayAdapter<Soda> {
    public SodaListAdapter(Context context) {
        super(context, 0);
    }

    public void setSodaList(SodaList sodaList) {
        addAll(sodaList.getAsList());
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Soda soda = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.soda_list_item, parent, false);
        }

        // TODO: should have a class for the item view ideally
        // TODO: viewholder pattern
        TextView sodaNameView = (TextView)convertView.findViewById(R.id.sodaname);
        sodaNameView.setText(soda.getName());

        return convertView;
    }
}
