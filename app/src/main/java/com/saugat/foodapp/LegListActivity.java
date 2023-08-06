package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LegListActivity extends AppCompatActivity {

    private List<LegExercise> legExerciseList;
    private ListView listView;
    private LegExerciseAdapter adapter;
    private DBHelper dbHelper;
    private Button buttonAddExercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);

        // Fetch chest exercises from the database
        List<LegExercise> legExerciseList = dbHelper.getLegExercises();
        // Set up the adapter
        adapter = new LegExerciseAdapter(this, R.layout.legs_exercise_list_item, legExerciseList);
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
                        String exerciseName = legExerciseList.get(i).getName();
                        dbHelper.insertUserExercise(exerciseName);
                    }
                }
                Toast.makeText(LegListActivity.this, "Selected exercises added to user_exercises table.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
