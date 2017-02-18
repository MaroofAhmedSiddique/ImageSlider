package com.imageslider.maroof;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;

/**
 * Created by Maroof Ahmed Siddique on 2/18/2017.
 */
public class ListAdapter extends BaseAdapter {

    private Context mContext;

    public ListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return SliderLayout.Transformer.values().length;
    }

    @Override
    public Object getItem(int position) {
        return SliderLayout.Transformer.values()[position].toString();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            convertView = inflater.inflate(R.layout.item, null);

            holder = new ViewHolder();

            holder.mItem = (TextView) convertView.findViewById(R.id.list_item_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mItem.setText(getItem(position).toString());

        return convertView;
    }

    private class ViewHolder {
        TextView mItem;
    }
}
