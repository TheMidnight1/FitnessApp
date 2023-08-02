package com.saugat.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etFirstName, etLastName, etPassword, etConfirmPassword;
    Button btnRegister;
    TextView tvLogin;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.emailEditText);
        etFirstName = findViewById(R.id.firstNameEditText);
        etLastName = findViewById(R.id.lastNameEditText);
        etPassword = findViewById(R.id.passwordEditText);
        etConfirmPassword = findViewById(R.id.confirmPasswordEditText);

        btnRegister = findViewById(R.id.registerButton);
        tvLogin = findViewById(R.id.loginTextView);

        // Create an instance of SQLiteOpenHelper
        SQLiteOpenHelper dbHelper = new DBHelper(this);

        // Get a writable database instance
        db = dbHelper.getWritableDatabase();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String email = etEmail.getText().toString().trim();
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                // Validate user input
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(firstName)) {
                    etFirstName.setError("First name is required");
                    return;
                }

                if (TextUtils.isEmpty(lastName)) {
                    etLastName.setError("Last name is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Password is required");
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Confirm password is required");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    etConfirmPassword.setError("Passwords do not match");
                    return;
                }

                // Create a ContentValues object and put the user data into it
                ContentValues values = new ContentValues();
                values.put("email", email);
                values.put("first_name", firstName);
                values.put("last_name", lastName);
                values.put("password", password);
                values.put("confirm_password", confirmPassword);

                // Insert the user data into the "users" table
                long result = db.insert("users", null, values);

                if (result != -1) {
                    // Show a message to the user
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    // Redirect the user to the login page
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Show an error message to the user
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }

                // Close the database connection
                db.close();
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
