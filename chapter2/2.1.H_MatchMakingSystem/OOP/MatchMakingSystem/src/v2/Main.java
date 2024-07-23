package v2;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        MatchMakingSystem system = new MatchMakingSystem(
                asList(
                        new Individual(Individual.Gender.FEMALE
                                , 18
                                , "Hi, i am jack ..."
                                , "swimming, cooking, dancing, jogging, hiking"
                                , new Individual.Coord(1, 3)),
                        new Individual(Individual.Gender.MALE
                                , 20
                                , "Hi, i am Alice ..."
                                , "boxing, cooking, dancing, coding, hiking"
                                , new Individual.Coord(7, 1)),
                        new Individual(Individual.Gender.FEMALE
                                , 22
                                , "Hi, i am Effy ..."
                                , "piano, music, coding, photo, hiking"
                                , new Individual.Coord(2, 0)),
                        new Individual(Individual.Gender.MALE
                                , 29
                                , "Hi, i am Cathy ..."
                                , "swimming, cooking, dancing, jogging, fishing"
                                , new Individual.Coord(4, 4)),
                        new Individual(Individual.Gender.FEMALE
                                , 24
                                , "Hi, i am Yoyo ..."
                                , "booking, learning, playing, yoyo, hiking"
                                , new Individual.Coord(7, 3))

                ), new DistanceBased()
        );
        system.match();
    }
}