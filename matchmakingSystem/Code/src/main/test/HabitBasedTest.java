import org.junit.jupiter.api.Test;
import org.v1.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HabitBasedTest {

    @Test
    void testMatchByDistanceBased() {
        var system = new MatchmakingSystem(new HabitBased());
        var individual1 = new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading,dancing", new Coord(0, 0), system);
        var individual2 = new Individual(Gender.FEMALE, 23, "Hi, I'm B.", "coding,reading,dancing,traveling", new Coord(0, 0), system);
        var individual3 = new Individual(Gender.FEMALE, 21, "Hi, I'm C.", "coding,dancing", new Coord(0, 0), system);
        var individual4 = new Individual(Gender.FEMALE, 21, "Hi, I'm D.", "coding,reading,music,traveling", new Coord(0, 0), system);

        system.match();

        assertEquals(individual1.getMatchWith(), individual2);
        assertEquals(individual2.getMatchWith(), individual1);
        assertEquals(individual3.getMatchWith(), individual1);
        assertEquals(individual4.getMatchWith(), individual2);
    }
}
