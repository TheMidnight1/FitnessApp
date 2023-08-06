package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity {
    ViewPager viewPager;
    GridView gridView;
    ArrayList<Integer> arrayList = new ArrayList<>();
    DBHelper dbHelper = new DBHelper(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        gridView = findViewById(R.id.gridView);
//        dbHelper.insertExercise("Dumbell Pullover", "Lie flat on a bench and push the dumbell away from your chest.", "Chest");
//        dbHelper.insertExercise("Push-ups", "Place your hands on the floor and push your body up.", "Chest");
//        dbHelper.insertExercise("Dumbbell Flyes", "Lie on a bench and bring the dumbbells together above your chest.", "Chest");
//
//        // Add exercises for abs
//        dbHelper.insertExercise("Crunches", "Lie on your back and lift your upper body towards your knees.", "Abs");
//        dbHelper.insertExercise("Plank", "Hold a push-up position with your body in a straight line.", "Abs");
//        dbHelper.insertExercise("Leg Raises", "Lie on your back and lift your legs towards the ceiling.", "Abs");
//
//        // Add exercises for legs
//        dbHelper.insertExercise("Squats", "Stand with your feet shoulder-width apart and squat down.", "Legs");
//        dbHelper.insertExercise("Lunges", "Step forward with one leg and bend both knees to lunge.", "Legs");
//        dbHelper.insertExercise("Leg Press", "Sit on a leg press machine and push the weight away with your legs.", "Legs");
//
//        // Add exercises for triceps
//        dbHelper.insertExercise("Tricep Dips", "Support your body on parallel bars and lower your body.", "Triceps");
//        dbHelper.insertExercise("Overhead Tricep Extension", "Hold a dumbbell overhead and lower it behind your head.", "Triceps");
//        dbHelper.insertExercise("Tricep Pushdowns", "Attach a rope to a cable machine and push it down with your arms.", "Triceps");
//
//        // Add exercises for back
//        dbHelper.insertExercise("Pull-ups", "Hang from a bar and pull your body up.", "Back");
//        dbHelper.insertExercise("Deadlifts", "Lift a barbell from the floor to a standing position.", "Back");
//        dbHelper.insertExercise("Bent-over Rows", "Bend over and lift a barbell towards your chest.", "Back");
//
//        // Add exercises for biceps
//        dbHelper.insertExercise("Bicep Curls", "Hold a dumbbell and curl your arm upwards.", "Biceps");
//        dbHelper.insertExercise("Hammer Curls", "Hold dumbbells with your palms facing each other and curl.", "Biceps");
//        dbHelper.insertExercise("Chin-ups", "Hang from a bar with your palms facing you and pull your body up.", "Biceps");


        List<GridItem> gridItems = new ArrayList<>();
        gridItems.add(new GridItem(R.drawable.chest, "Chest"));
        gridItems.add(new GridItem(R.drawable.triceps, "Triceps"));
        gridItems.add(new GridItem(R.drawable.back, "Back"));
        gridItems.add(new GridItem(R.drawable.biceps, "Biceps"));
        gridItems.add(new GridItem(R.drawable.leg, "Leg"));
        gridItems.add(new GridItem(R.drawable.abs, "Abs"));

        GridViewAdapter<GridItem> gridViewAdapter = new GridViewAdapter<>(this, gridItems);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: // If the user clicks on the Pizza grid item
                        // Start a new activity to show the list of Momo types
                        startActivity(new Intent(HomepageActivity.this, PizzaListActivity.class));
                        break;
                    case 1: // If the user clicks on the Burger grid item
                        // Start a new activity to show the list of Burger types
                        startActivity(new Intent(HomepageActivity.this, BurgerListActivity.class));
                        break;
                    case 2: // If the user clicks on the Fries grid item
                        // Start a new activity to show the list of Fries types
                        startActivity(new Intent(HomepageActivity.this, FriesListActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(HomepageActivity.this, BicepsListActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(HomepageActivity.this, LegListActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(HomepageActivity.this, AbsListActivity.class));
                        break;
                    default:
                        break;
                }

            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logoutIcon:
                // Logout the user
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.tab_Fragment:
                SharedPreferences preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent intent1 = new Intent(this, FragmentTabDemo.class);
                startActivity(intent1);
                finish();
                return true;
            case R.id.myExercises:
                // Logout the user
                Intent intent2 = new Intent(this, UserExerciseActivity.class);
                startActivity(intent2);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }

    }
}