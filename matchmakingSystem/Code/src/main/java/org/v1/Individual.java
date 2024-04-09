package org.v1;

import java.util.List;

public class Individual {
    private final int id;
    private Gender gender;
    private final int age;
    private String intro;
    private List<String> habits;
    private Coord coord;
    private int lastId = 1;
    private final MatchmakingSystem matchmakingSystem;

    public Individual(Gender gender,
                      int age,
                      String intro,
                      String habits,
                      Coord coord,
                      MatchmakingSystem matchmakingSystem) {
        this.gender = gender;
        this.age = age;
        this.intro = intro;
        this.habits = List.of(habits.split(","));
        this.coord = coord;
        this.lastId += 1;
        this.id = this.lastId;
        this.matchmakingSystem = matchmakingSystem;
        matchmakingSystem.register(this);
    }

    public void setHabits(String habits) {
        this.habits = List.of(habits.split(","));
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setHabits(List<String> habits) {
        this.habits = habits;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHabits() {
        return habits;
    }

    public String getIntro() {
        return intro;
    }

    public Coord getCoord() {
        return coord;
    }
}
