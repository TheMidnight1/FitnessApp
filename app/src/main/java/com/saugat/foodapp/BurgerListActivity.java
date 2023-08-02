package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class BurgerListActivity extends AppCompatActivity {

    private List<TricepsExercise> tricepsExerciseList;
    private ListView listView;
    private TricepsExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_list);

        listView = findViewById(R.id.listViewExercises);
        // Create a list of chest exercises
        tricepsExerciseList = new ArrayList<>();
        tricepsExerciseList.add(new TricepsExercise("Bench Press", "Lie flat on your back and press the barbell away from your chest."));
       tricepsExerciseList.add(new TricepsExercise("Push-ups", "Support your body with your arms and push up and down."));
        tricepsExerciseList.add(new TricepsExercise("Dumbbell Flyes", "Lie on a bench and open and close your arms with dumbbells."));
        // Add more exercises as needed

        // Set up the adapter
        adapter = new TricepsExerciseAdapter(this, R.layout.tricpes_exercise_list_item, tricepsExerciseList);
        listView.setAdapter(adapter);
    }
}
