package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class FriesListActivity extends AppCompatActivity {

    private List<BackExercise> backExerciseList;
    private ListView listView;
    private BackExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fries_list);

        listView = findViewById(R.id.listViewExercises);

        // Create a list of chest exercises
        backExerciseList = new ArrayList<>();
        backExerciseList.add(new BackExercise("Pull up", "Lie flat on your back and press the barbell away from your chest."));
        backExerciseList.add(new BackExercise("Push-ups", "Support your body with your arms and push up and down."));
        backExerciseList.add(new BackExercise("Dumbbell Flyes", "Lie on a bench and open and close your arms with dumbbells."));
        // Add more exercises as needed

        // Set up the adapter
        adapter = new BackExerciseAdapter(this, R.layout.back_exercise_list_item, backExerciseList);
        listView.setAdapter(adapter);
    }
}
