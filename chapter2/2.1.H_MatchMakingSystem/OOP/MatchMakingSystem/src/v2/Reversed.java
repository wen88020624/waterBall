package v2;

import java.util.Collections;
import java.util.List;

public class Reversed implements MatchMakingStrategy {
    private final MatchMakingStrategy matchMakingStrategy;

    public Reversed(MatchMakingStrategy matchMakingStrategy) {
        this.matchMakingStrategy = matchMakingStrategy;
    }

    @Override
    public List<Individual> match(Individual individual, List<Individual> individuals) {
        List<Individual> candidates = matchMakingStrategy.match(individual, individuals);
        Collections.reverse(candidates);
        return candidates;
    }
}
