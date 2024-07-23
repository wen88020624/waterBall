package v2;

import java.util.List;

public class MatchMakingSystem {
    private List<Individual> individuals;
    private MatchMakingStrategy strategy;

    public MatchMakingSystem(List<Individual> individuals, MatchMakingStrategy strategy) {
        this.individuals = individuals;
        this.strategy = strategy;
    }

    public void match() {
        for (Individual matcher : individuals) {
            strategy.match(matcher, individuals);
        }
    }
}
