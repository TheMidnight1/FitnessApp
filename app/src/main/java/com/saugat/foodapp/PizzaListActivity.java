package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class PizzaListActivity extends AppCompatActivity {

    private List<ChestExercise> chestExerciseList;
    private ListView listView;
    private ChestExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

        listView = findViewById(R.id.listViewExercises);

        // Create a list of chest exercises
        chestExerciseList = new ArrayList<>();
        chestExerciseList.add(new ChestExercise("Bench Press", "Lie flat on your back and press the barbell away from your chest."));
        chestExerciseList.add(new ChestExercise("Push-ups", "Support your body with your arms and push up and down."));
        chestExerciseList.add(new ChestExercise("Dumbbell Flyes", "Lie on a bench and open and close your arms with dumbbells."));
        // Add more exercises as needed

        // Set up the adapter
        adapter = new ChestExerciseAdapter(this, R.layout.chest_exercise_list_item, chestExerciseList);
        listView.setAdapter(adapter);
    }
}
