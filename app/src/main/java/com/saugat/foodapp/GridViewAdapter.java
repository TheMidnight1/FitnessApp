package com.saugat.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;public class GridViewAdapter<T> extends BaseAdapter {
    private Context mContext;
    private List<T> mData;

    public GridViewAdapter(Context context, List<T> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.homepage_grid1, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.grid_image);
        TextView textView = view.findViewById(R.id.grid_caption);
        textView.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        T item = mData.get(position);

        if (item instanceof GridItem) {
            GridItem gridItem = (GridItem) item;
            imageView.setImageResource(gridItem.getImageResource());
            textView.setText(gridItem.getCaption());
        }

        return view;
    }
}
