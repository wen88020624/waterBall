package org.v1;

import java.util.List;

public interface MatchmakingStrategy {
    void match(List<Individual> individuals);
}
