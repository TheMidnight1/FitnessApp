package com.saugat.foodapp;
public class AbsExercise {
    private String name;
    private String description;

    public AbsExercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

