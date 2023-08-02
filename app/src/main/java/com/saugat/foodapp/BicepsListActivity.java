package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class BicepsListActivity extends AppCompatActivity {

    private List<BicepsExercise> bicepsExerciseList;
    private ListView listView;
    private BicepsExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps_list);

        listView = findViewById(R.id.listViewExercises);
        // Create a list of chest exercises
        bicepsExerciseList = new ArrayList<>();
        bicepsExerciseList.add(new BicepsExercise("Dumbell Pull over", "Lie flat on your back and press the barbell away from your chest."));
        bicepsExerciseList.add(new BicepsExercise("Push-ups", "Support your body with your arms and push up and down."));
        bicepsExerciseList.add(new BicepsExercise("Dumbbell Flyes", "Lie on a bench and open and close your arms with dumbbells."));
        // Add more exercises as needed

        // Set up the adapter
        adapter = new BicepsExerciseAdapter(this, R.layout.biceps_exercise_list_item, bicepsExerciseList);
        listView.setAdapter(adapter);
    }
}
