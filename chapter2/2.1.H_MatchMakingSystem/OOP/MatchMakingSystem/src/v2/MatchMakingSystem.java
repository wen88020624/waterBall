package v2;

import java.util.List;

public class MatchMakingSystem {
    private List<Individual> individuals;

    public MatchMakingSystem(List<Individual> individuals) {
        this.individuals = individuals;
    }

    public void match() {
        for (Individual matcher : individuals) {
            MatchStrategy matchStrategy = matcher.getMatchStrategy();
            matchStrategy.match(matcher, individuals);
        }
    }
}
