package com.saugat.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ChestExerciseAdapter extends ArrayAdapter<ChestExercise> {

    private int layoutResource;

    public ChestExerciseAdapter(Context context, int resource, List<ChestExercise> exercises) {
        super(context, resource, exercises);
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
        ChestExercise exercise = getItem(position);

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
    public ChestExercise getItem(int position) {
        // We explicitly cast the return value to ChestExercise
        return (ChestExercise) super.getItem(position);
    }
}
