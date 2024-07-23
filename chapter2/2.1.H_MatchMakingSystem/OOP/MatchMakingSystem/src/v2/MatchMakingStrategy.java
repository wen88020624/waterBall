package v2;

import java.util.List;

public interface MatchMakingStrategy {
    public List<Individual> match(Individual i, List<Individual> individuals);
}
