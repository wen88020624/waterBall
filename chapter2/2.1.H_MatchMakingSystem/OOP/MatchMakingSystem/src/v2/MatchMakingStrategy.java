package v2;

import java.util.List;

public interface MatchMakingStrategy {
    public void match(Individual i, List<Individual> individuals);
}
