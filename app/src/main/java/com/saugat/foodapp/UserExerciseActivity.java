package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class UserExerciseActivity extends AppCompatActivity {

    private ListView listView;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_exercises);

        listView = findViewById(R.id.listViewUserExercises);
        dbHelper = new DBHelper(this);

        // Fetch user exercises from the database for the logged-in user
        List<String> userExercises = dbHelper.getUserExercises();

        // Set up the adapter to display the list of user exercises in the ListView
        UserExerciseAdapter adapter = new UserExerciseAdapter(this, R.layout.user_exercise_list_item, userExercises);
        listView.setAdapter(adapter);
    }
}
