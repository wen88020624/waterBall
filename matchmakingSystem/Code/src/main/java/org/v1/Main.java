package org.v1;

public class Main {
    public static void main(String[] args) {
        var matchmakingSystem = new MatchmakingSystem(new DistanceBased());

        new Individual(Gender.FEMALE, 18, "Hi", "baseball,sleeping,hiking", new Coord(1, 1), matchmakingSystem);
        new Individual(Gender.MALE, 28, "Hi", "swimming,hiking,sleeping", new Coord(6, 9), matchmakingSystem);
        new Individual(Gender.FEMALE, 24, "Hi", "biking,reading,jogging", new Coord(4, 5), matchmakingSystem);
        new Individual(Gender.MALE, 23, "Hi", "swimming,sleeping,hiking", new Coord(2, 6), matchmakingSystem);
        new Individual(Gender.FEMALE, 26, "Hi", "reading,dancing,baseball", new Coord(3, 7), matchmakingSystem);

        matchmakingSystem.match();
    }
}