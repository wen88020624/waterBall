package org.v1;

import java.util.ArrayList;
import java.util.List;

public class MatchmakingSystem {
    private final MatchmakingStrategy matchmakingStrategy;

    private List<Individual> individuals;

    public MatchmakingSystem(MatchmakingStrategy matchmakingStrategy) {
        this.matchmakingStrategy = matchmakingStrategy;
        this.individuals = new ArrayList<>();
    }

    public void match() {
        matchmakingStrategy.match(individuals);
    };

    public void register(Individual individual) {
        this.individuals.add(individual);
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
    }
}
