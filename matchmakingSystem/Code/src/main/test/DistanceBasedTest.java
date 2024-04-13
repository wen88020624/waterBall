import org.junit.jupiter.api.Test;
import org.v1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class DistanceBasedTest {

    @Test
    void testMatchByDistanceBased() {
        var system = new MatchmakingSystem(new DistanceBased());
        var individual1 = new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading", new Coord(6, 9), system);
        var individual2 = new Individual(Gender.FEMALE, 23, "Hi, I'm B.", "music,traveling", new Coord(2, 3), system);
        var individual3 = new Individual(Gender.FEMALE, 21, "Hi, I'm C.", "music,traveling", new Coord(2, 3), system);
        var individual4 = new Individual(Gender.FEMALE, 21, "Hi, I'm D.", "music,traveling", new Coord(2, 3), system);

        system.match();

        assertEquals(individual1.getMatchWith(), individual2);
        assertEquals(individual2.getMatchWith(), individual3);
        assertEquals(individual3.getMatchWith(), individual2);
        assertEquals(individual4.getMatchWith(), individual2);
    }

    @Test
    void testNoMatchFoundExceptionByDistanceBased() {
        var system = new MatchmakingSystem(new DistanceBased());
        new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading", new Coord(6, 9), system);
        
        Exception exception =  assertThrowsExactly(RuntimeException.class, system::match);
        assertEquals("No match found for individual!", exception.getMessage());
    }

}
