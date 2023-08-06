package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AbsListActivity extends AppCompatActivity {

    private List<AbsExercise> absExerciseList;
    private ListView listView;
    private AbsExerciseAdapter adapter;
    private DBHelper dbHelper;
    private Button buttonAddExercises;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);
        // Create a list of chest exercises
        // Fetch chest exercises from the database
        List<AbsExercise> absExerciseList = dbHelper.getAbsExercises();

        // Set up the adapter
        adapter = new AbsExerciseAdapter(this, R.layout.abs_exercise_list_item, absExerciseList);
        listView.setAdapter(adapter);

        buttonAddExercises = findViewById(R.id.buttonAddExercises);
        buttonAddExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the list of selected exercises from the adapter
                List<Boolean> selectedExercises = adapter.getExerciseSelectionList();
                for (int i = 0; i < selectedExercises.size(); i++) {
                    if (selectedExercises.get(i)) {
                        // Save the selected exercise to the "user_exercises" table
                        String exerciseName = absExerciseList.get(i).getName();
                        dbHelper.insertUserExercise(exerciseName);
                    }
                }
                Toast.makeText(AbsListActivity.this, "Selected exercises added to user_exercises table.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
