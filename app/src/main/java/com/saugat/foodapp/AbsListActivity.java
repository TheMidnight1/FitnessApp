package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class AbsListActivity extends AppCompatActivity {

    private List<AbsExercise> absExerciseList;
    private ListView listView;
    private AbsExerciseAdapter adapter;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);
        // Create a list of chest exercises
        // Fetch chest exercises from the database
        List<AbsExercise> absExerciseList = dbHelper.getAbsExercises();

        // Set up the adapter
        adapter = new AbsExerciseAdapter(this, R.layout.abs_exercise_list_item, absExerciseList);
        listView.setAdapter(adapter);
    }
}
