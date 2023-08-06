    package com.saugat.foodapp;

    import android.annotation.SuppressLint;
    import android.content.ContentValues;
    import android.content.Context;
    import android.content.SharedPreferences;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

    import java.util.ArrayList;
    import java.util.List;

    public class DBHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "Exercise.db";
        private static final int DATABASE_VERSION = 2;
        private Context context; // Add a Context variable to hold the context

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context; // Assign the context to the class variable

        }


        @Override
        public void onCreate(SQLiteDatabase db) {
//                 Create the "users" table
            db.execSQL("CREATE TABLE users (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "email TEXT," +
                    "first_name TEXT," +
                    "last_name TEXT," +
                    "password TEXT," +
                    "confirm_password TEXT" +
                    ")");
            db.execSQL("CREATE TABLE exercises (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "description TEXT," +
                    "category TEXT" +
                    ")");
            db.execSQL("CREATE TABLE user_exercises (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "user_id INTEGER," +
                    "exercise_id INTEGER," +
                    "FOREIGN KEY(user_id) REFERENCES users(_id)," +
                    "FOREIGN KEY(exercise_id) REFERENCES exercises(_id)" +
                    ")");

            db.execSQL("CREATE TABLE user_exercise (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "user_id INTEGER," +
                    "exercise_name TEXT," +
                    "FOREIGN KEY(user_id) REFERENCES users(_id)," +
                    "FOREIGN KEY(exercise_name) REFERENCES exercises(name)" +
                    ")");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS user_exercises");
            db.execSQL("DROP TABLE IF EXISTS user_exercise");

            // Recreate the tables with the updated schema
            onCreate(db);
        }
        public long insertExercise(String name, String description, String category) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("description", description);
            values.put("category", category);

            // Insert the row and get the inserted row's ID
            long exerciseId = db.insert("exercises", null, values);

            // Close the database connection
            db.close();

            // Return the ID of the newly inserted exercise
            return exerciseId;
        }
        // FOR FETCHING CHEST DATA
        public List<ChestExercise> getChestExercises() {
            List<ChestExercise> chestExerciseList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM exercises WHERE category=?", new String[]{"Chest"});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));
                    chestExerciseList.add(new ChestExercise(name, description));
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return chestExerciseList;
        }
        // FOR FETCHING CHEST DATA
        public List<BicepsExercise> getBicepsExercises() {
            List<BicepsExercise> bicepsExerciseList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM exercises WHERE category=?", new String[]{"Biceps"});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));
                    bicepsExerciseList.add(new BicepsExercise(name, description));
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return bicepsExerciseList;
        }
        // FOR FETCHING Triceps DATA
        public List<TricepsExercise> getTricepsExercises() {
            List<TricepsExercise> tricepsExerciseList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM exercises WHERE category=?", new String[]{"Triceps"});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));
                    tricepsExerciseList.add(new TricepsExercise(name, description));
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return tricepsExerciseList;
        }

        // FOR FETCHING Back DATA
        public List<BackExercise> getBackExercises() {
            List<BackExercise> backExerciseList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM exercises WHERE category=?", new String[]{"Back"});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));
                    backExerciseList.add(new BackExercise(name, description));
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return backExerciseList;
        }
        // FOR FETCHING LEG DATA
        public List<LegExercise> getLegExercises() {
            List<LegExercise> legExerciseList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM exercises WHERE category=?", new String[]{"Legs"});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));
                    legExerciseList.add(new LegExercise(name, description));
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return legExerciseList;
        }
        // FOR FETCHING ABS DATA
        public List<AbsExercise> getAbsExercises() {
            List<AbsExercise> absExerciseList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM exercises WHERE category=?", new String[]{"Abs"});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));
                    absExerciseList.add(new AbsExercise(name, description));
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return absExerciseList;
        }

        public int getLoggedInUserId() {
            SharedPreferences preferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            return preferences.getInt("userId", -1); // Return -1 if userId is not found
        }

        public long insertUserExercise(String exerciseName) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("user_id", getLoggedInUserId()); // Replace this with the method to get the logged-in user ID
            values.put("exercise_name", exerciseName);

            // Insert the row and get the inserted row's ID
            long userExerciseId = db.insert("user_exercise", null, values);

            // Close the database connection
            db.close();

            // Return the ID of the newly inserted user exercise
            return userExerciseId;
        }
        public List<String> getUserExercises() {
            List<String> userExercises = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT exercise_name FROM user_exercise WHERE user_id=?", new String[]{String.valueOf(getLoggedInUserId())});

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String exerciseName = cursor.getString(cursor.getColumnIndex("exercise_name"));
                    userExercises.add(exerciseName);
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return userExercises;
        }
    }
