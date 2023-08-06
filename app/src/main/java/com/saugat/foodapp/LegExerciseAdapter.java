package com.saugat.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LegExerciseAdapter extends ArrayAdapter<LegExercise> {

    private int layoutResource;

    static class ViewHolder {
        CheckBox checkBoxExercise;
        TextView nameTextView;
        TextView descriptionTextView;
    }

    public LegExerciseAdapter(Context context, int resource, List<LegExercise> exercises) {
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
            holder.checkBoxExercise = view.findViewById(R.id.checkBoxExercise);
            holder.nameTextView = view.findViewById(R.id.exerciseNameTextView);
            holder.descriptionTextView = view.findViewById(R.id.exerciseDescriptionTextView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        LegExercise exercise = getItem(position);

        if (exercise != null) {
            // Set the exercise name and description to the respective TextViews
            holder.nameTextView.setText(exercise.getName());
            holder.descriptionTextView.setText(exercise.getDescription());

            // Set the checkbox state
            holder.checkBoxExercise.setChecked(exercise.isChecked());
            // Set a tag on the checkbox to remember its position in the list
            holder.checkBoxExercise.setTag(position);

            // Add a listener to the checkbox to update the exercise's state when clicked
            holder.checkBoxExercise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int pos = (Integer) buttonView.getTag();
                    LegExercise clickedExercise = getItem(pos);
                    clickedExercise.setChecked(isChecked);
                }
            });
        }

        return view;
    }

    // Get the list of selected exercises
    public List<Boolean> getExerciseSelectionList() {
        List<Boolean> selectionList = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            LegExercise exercise = getItem(i);
            if (exercise != null) {
                selectionList.add(exercise.isChecked());
            } else {
                selectionList.add(false);
            }
        }
        return selectionList;
    }
}
