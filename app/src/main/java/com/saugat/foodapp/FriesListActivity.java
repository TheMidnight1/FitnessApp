package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FriesListActivity extends AppCompatActivity {

    private List<BackExercise> backExerciseList;
    private ListView listView;
    private BackExerciseAdapter adapter;

    private DBHelper dbHelper;
    private Button buttonAddExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fries_list);
        buttonAddExercises = findViewById(R.id.buttonAddExercises);
        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);
        List<BackExercise> backExerciseList = dbHelper.getBackExercises();
        // Set up the adapter
        adapter = new BackExerciseAdapter(this, R.layout.back_exercise_list_item, backExerciseList);
        listView.setAdapter(adapter);

        buttonAddExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the list of selected exercises from the adapter
                List<Boolean> selectedExercises = adapter.getExerciseSelectionList();
                for (int i = 0; i < selectedExercises.size(); i++) {
                    if (selectedExercises.get(i)) {
                        // Save the selected exercise to the "user_exercises" table
                        String exerciseName = backExerciseList.get(i).getName();
                        dbHelper.insertUserExercise(exerciseName);
                    }
                }
                Toast.makeText(FriesListActivity.this, "Selected exercises added to user_exercises table.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
