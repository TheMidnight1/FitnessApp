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

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fries_list);

        listView = findViewById(R.id.listViewExercises);
        dbHelper = new DBHelper(this);
        List<BackExercise> backExerciseList = dbHelper.getBackExercises();
        // Set up the adapter
        adapter = new BackExerciseAdapter(this, R.layout.back_exercise_list_item, backExerciseList);
        listView.setAdapter(adapter);
    }
}
