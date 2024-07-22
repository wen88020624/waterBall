package v2;

import java.util.List;

public interface MatchStrategy {
    public void match(Individual matcher, List<Individual> individuals);
}
