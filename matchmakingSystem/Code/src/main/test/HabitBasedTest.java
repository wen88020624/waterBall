import org.junit.jupiter.api.Test;
import org.v1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class HabitBasedTest {

    @Test
    void testMatchByHabitBased() {
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

    @Test
    void testNoMatchFoundExceptionByHabitBased() {
        var system = new MatchmakingSystem(new HabitBased());
        var individual1 = new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading,dancing", new Coord(0, 0), system);
        Exception exception =  assertThrowsExactly(RuntimeException.class, system::match);
        assertEquals("No match found for individual!", exception.getMessage());
    }

    @Test
    void testMatchByHabitBasedReverse() {
        var system = new MatchmakingSystem(new HabitBasedReverse());
        var individual1 = new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading,dancing", new Coord(0, 0), system);
        var individual2 = new Individual(Gender.FEMALE, 23, "Hi, I'm B.", "jumping,jogging", new Coord(0, 0), system);
        var individual3 = new Individual(Gender.FEMALE, 21, "Hi, I'm C.", "swimming,hiking", new Coord(0, 0), system);
        var individual4 = new Individual(Gender.FEMALE, 21, "Hi, I'm D.", "coding,reading,music,traveling", new Coord(0, 0), system);

        system.match();

        assertEquals(individual1.getMatchWith(), individual2);
        assertEquals(individual2.getMatchWith(), individual1);
        assertEquals(individual3.getMatchWith(), individual1);
        assertEquals(individual4.getMatchWith(), individual2);
    }

    @Test
    void testNoMatchFoundExceptionByHabitBasedReverse() {
        var system = new MatchmakingSystem(new HabitBased());
        var individual1 = new Individual(Gender.MALE, 25, "Hi, I'm A.", "coding,reading,dancing", new Coord(0, 0), system);
        Exception exception =  assertThrowsExactly(RuntimeException.class, system::match);
        assertEquals("No match found for individual!", exception.getMessage());
    }
}
