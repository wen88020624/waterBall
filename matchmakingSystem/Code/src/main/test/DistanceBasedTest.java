import org.junit.jupiter.api.Test;
import org.v1.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DistanceBasedTest {

    @Test
    void testMatchForTwoCloseIndividuals() {
        var system = new MatchmakingSystem(new DistanceBased());
        Individual individual1 = new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading", new Coord(1, 1), system);
        Individual individual2 = new Individual(Gender.FEMALE, 23, "Hi, I'm B.", "music,traveling", new Coord(2, 2), system);
        Individual individual3 = new Individual(Gender.FEMALE, 21, "Hi, I'm C.", "music,traveling", new Coord(2, 2), system);

        system.match();
        assertTrue(isMatchedWith(individual1, individual2));
    }

    private boolean isMatchedWith(Individual individual1, Individual individual2) {
        return false;
    }
}
