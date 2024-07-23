package v2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Individual {
    private static int id=0;
    private final int userId;
    private final Gender gender;
    private int age;
    private String intro;
    private List<String> habits = new ArrayList<>();
    private Coord coord;

    private Individual matchPerson;

    public Individual(Gender gender, int age, String intro, String habitStr, Coord coord) {
        this.userId = id++;
        this.gender = gender;
        setAge(age);
        this.intro = intro;
        setHabits(habitStr);
        this.coord = coord;
    }

    private void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        } else {
            System.out.println("Must be at least eighteen years old");
        }
    }

    public void match(Individual individual) {
        this.matchPerson = individual;
    }

    public double distanceTo(Individual individual) {
        return this.getCoord().distanceTo(individual.getCoord());
    }

    public int getInterestOverlapWith(Individual individual) {
        Set<String> thisHabits = new HashSet<>(this.getHabits());
        Set<String> otherHabits = new HashSet<>(individual.getHabits());

        thisHabits.retainAll(otherHabits);
        return thisHabits.size();
    }

    public List<String> getHabits() {
        return habits;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setHabits(String habitStr) {
        String[] allHabits = habitStr.split(",");
        for (String habit : allHabits) {
            habit = habit.trim();
            if (habit.length() <= 10) {
                this.habits.add(habit);

            } else {
                System.out.println("Habit's length cannot exceed 10 characters!");
            }
        }
    }

    public enum Gender {
        FEMALE, MALE;
    }

    public static class Coord {
        private int x;
        private int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public double distanceTo(Coord otherPeopleCoord) {
            return Math.sqrt(Math.pow(this.x - otherPeopleCoord.x, 2)
                    + Math.pow(this.y - otherPeopleCoord.y, 2));
        }
    }
    public String getIntro() {
        return intro;
    }

    public Individual getMatchPerson() {
        return matchPerson;
    }
}
