package com.saugat.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserExerciseAdapter extends ArrayAdapter<String> {

    private int layoutResource;

    public UserExerciseAdapter(Context context, int resource, List<String> exercises) {
        super(context, resource, exercises);
        layoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(layoutResource, null);

            holder = new ViewHolder();
            holder.exerciseNameTextView = view.findViewById(R.id.exerciseNameTextView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String exerciseName = getItem(position);

        if (exerciseName != null) {
            // Set the exercise name to the TextView
            holder.exerciseNameTextView.setText(exerciseName);
        }

        return view;
    }

    static class ViewHolder {
        TextView exerciseNameTextView;
    }
}
