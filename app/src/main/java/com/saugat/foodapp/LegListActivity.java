package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class LegListActivity extends AppCompatActivity {

    private List<LegExercise> legExerciseList;
    private ListView listView;
    private LegExerciseAdapter adapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);

        // Fetch chest exercises from the database
        List<LegExercise> legExerciseList = dbHelper.getLegExercises();
        // Set up the adapter
        adapter = new LegExerciseAdapter(this, R.layout.biceps_exercise_list_item, legExerciseList);
        listView.setAdapter(adapter);
    }
}
