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
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this); // Initialize the dbHelper object

        // Fetch biceps exercises from the database
        bicepsExerciseList = dbHelper.getBicepsExercises();

        // Set up the adapter
        adapter = new BicepsExerciseAdapter(this, R.layout.biceps_exercise_list_item, bicepsExerciseList);
        listView.setAdapter(adapter);
    }
}
