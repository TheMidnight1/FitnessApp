package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BurgerListActivity extends AppCompatActivity {

    private List<TricepsExercise> tricepsExerciseList;
    private ListView listView;
    private TricepsExerciseAdapter adapter;
    private DBHelper dbHelper;
    private Button buttonAddExercises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);

        // Fetch chest exercises from the database
        List<TricepsExercise> tricepsExerciseList = dbHelper.getTricepsExercises();
        // Set up the adapter
        adapter = new TricepsExerciseAdapter(this, R.layout.tricpes_exercise_list_item, tricepsExerciseList);
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
                        String exerciseName = tricepsExerciseList.get(i).getName();
                        dbHelper.insertUserExercise(exerciseName);
                    }
                }
                Toast.makeText(BurgerListActivity.this, "Selected exercises added to user_exercises table.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
