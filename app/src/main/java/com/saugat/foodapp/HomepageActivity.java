package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        gridView = findViewById(R.id.gridView);


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
                Intent intent1 = new Intent(this, FragmentTabDemo.class);
                startActivity(intent1);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }

    }
}