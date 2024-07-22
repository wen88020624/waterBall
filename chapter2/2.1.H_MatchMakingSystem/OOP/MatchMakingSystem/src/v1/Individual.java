package v1;

import java.util.List;

public class Individual {
    private static int id=0;
    private final int userId;
    private final Gender gender;
    private final int age;
    private String intro;
    private List<String> habits;
    private Coord coord;
    private String matchStrategy;

    private Individual matchPerson;

    public Individual(Gender gender, int age, String intro, List<String> habits, Coord coord, String matchStrategy) {
        this.userId = id++;
        this.gender = gender;
        this.age = age;
        this.intro = intro;
        this.habits = habits;
        this.coord = coord;
        this.matchStrategy = matchStrategy;
    }

    public void match(Individual individual) {
        this.matchPerson = individual;
    }

    public double distanceTo(Individual individual) {
        return this.getCoord().distanceTo(individual.getCoord());
    }

    public List<String> getHabits() {
        return habits;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getMatchStrategy() {
        return matchStrategy;
    }

    public enum Gender {
        FEMALE, MALE
    }

    public class Coord {
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

}
