package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class PizzaListActivity extends AppCompatActivity {

    private List<ChestExercise> chestExerciseList;
    private ListView listView;
    private ChestExerciseAdapter adapter;
    private DBHelper dbHelper;
    private Button buttonAddExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);
        buttonAddExercises = findViewById(R.id.buttonAddExercises);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);

        // Fetch chest exercises from the database
        chestExerciseList = dbHelper.getChestExercises();
        // Set up the adapter
        adapter = new ChestExerciseAdapter(this, R.layout.chest_exercise_list_item, chestExerciseList);
        listView.setAdapter(adapter);

        buttonAddExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the list of selected exercises from the adapter
                List<Boolean> selectedExercises = adapter.getExerciseSelectionList();
                for (int i = 0; i < selectedExercises.size(); i++) {
                    if (selectedExercises.get(i)) {
                        // Save the selected exercise to the "user_exercises" table
                        String exerciseName = chestExerciseList.get(i).getName();
                        dbHelper.insertUserExercise(exerciseName);
                    }
                }
                Toast.makeText(PizzaListActivity.this, "Selected exercises added to user_exercises table.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
