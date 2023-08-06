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
    private DBHelper dbHelper;

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
    }
}
