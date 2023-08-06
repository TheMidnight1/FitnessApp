//package com.saugat.foodapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class AddCategoryActivity extends AppCompatActivity {
//
//    private EditText editTextCategoryName;
//    private Button buttonAddCategory;
//    private DBHelper dbHelper;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_category);
//
//        // Initialize views
//        editTextCategoryName = findViewById(R.id.editTextCategoryName);
//        buttonAddCategory = findViewById(R.id.buttonAddCategory);
//
//        // Initialize the DBHelper instance
//        dbHelper = new DBHelper(this);
//
//        // Handle "Add Category" button click
//        buttonAddCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String categoryName = editTextCategoryName.getText().toString().trim();
//                if (!categoryName.isEmpty()) {
//                    // Insert the category into the database
//                    long newRowId = dbHelper.insertCategory(categoryName);
//                    if (newRowId != -1) {
//                        // Category insertion successful
//                        Toast.makeText(AddCategoryActivity.this, "Category added to database", Toast.LENGTH_SHORT).show();
//                    } else {
//                        // Category insertion failed
//                        Toast.makeText(AddCategoryActivity.this, "Failed to add category", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(AddCategoryActivity.this, "Please enter a category name", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
