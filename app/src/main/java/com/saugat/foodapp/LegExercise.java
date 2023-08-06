package com.saugat.foodapp;
public class LegExercise {
    private String name;
    private String description;
    private boolean isChecked; // To keep track of the checkbox status

    public LegExercise(String name, String description) {
        this.name = name;
        this.description = description;
        this.isChecked = false; // By default, checkbox is not checked

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

