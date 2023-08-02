package com.saugat.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class BicepsExerciseAdapter extends ArrayAdapter<BicepsExercise> {

    private int layoutResource;

    public BicepsExerciseAdapter(Context context, int resource, List<BicepsExercise> exercises) {
        super(context, resource,exercises);
        layoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(layoutResource, null);
        }

        // Get the current exercise object
        BicepsExercise exercise = getItem(position);

        if (exercise != null) {
            // Set the exercise name and description to the respective TextViews
            TextView nameTextView = view.findViewById(R.id.exerciseNameTextView);
            TextView descriptionTextView = view.findViewById(R.id.exerciseDescriptionTextView);

            if (nameTextView != null) {
                nameTextView.setText(exercise.getName());
            }

            if (descriptionTextView != null) {
                descriptionTextView.setText(exercise.getDescription());
            }
        }

        return view;
    }

    @Override
    public BicepsExercise getItem(int position) {
        // We explicitly cast the return value to ChestExercise
        return (BicepsExercise) super.getItem(position);
    }
}
