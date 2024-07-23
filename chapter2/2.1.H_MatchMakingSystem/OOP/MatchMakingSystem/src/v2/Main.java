package v2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Individual> individuals = Arrays.asList(
                new Individual(Individual.Gender.FEMALE, 18, "Hi, I am Jack...", "swimming, cooking, dancing, jogging, hiking", new Individual.Coord(1, 3)),
                new Individual(Individual.Gender.MALE, 20, "Hi, I am Alice...", "boxing, cooking, dancing, coding, hiking", new Individual.Coord(7, 1)),
                new Individual(Individual.Gender.FEMALE, 22, "Hi, I am Effy...", "piano, music, coding, photo, hiking", new Individual.Coord(2, 0)),
                new Individual(Individual.Gender.MALE, 29, "Hi, I am Cathy...", "swimming, cooking, dancing, jogging, fishing", new Individual.Coord(4, 4)),
                new Individual(Individual.Gender.FEMALE, 24, "Hi, I am Yoyo...", "booking, learning, playing, yoyo, hiking", new Individual.Coord(7, 3))
        );

        MatchMakingSystem system = new MatchMakingSystem(individuals, new Reversed(new DistanceBased()));
        system.match();
    }
}