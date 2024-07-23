package v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HabitBased implements MatchMakingStrategy {
    @Override
    public List<Individual> match(Individual i, List<Individual> individuals) {
        List<Individual> candidates = new ArrayList<>();
        for (Individual candidate : individuals) {
            if (!i.equals(candidate)) {
                candidates.add(candidate);
            }
        }

        candidates.sort(Comparator.comparingInt(i::getInterestOverlapWith)
                .thenComparingInt(Individual::getUserId));

        return candidates;
    }
}
