package org.v1;

import java.util.List;

public class Individual {
    private final int id;
    private final Gender gender;
    private int age;
    private String intro;
    private List<String> habits;
    private Coord coord;

    public Individual(int id, Gender gender) {
        this.id = id;
        this.gender = gender;
    }

    public void setHabits(String habitsString) {
        this.habits = List.of(habitsString.split(","));
    }
}
