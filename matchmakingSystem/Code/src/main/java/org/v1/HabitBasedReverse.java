package org.v1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HabitBasedReverse implements MatchmakingStrategy {
    @Override
    public void match(List<Individual> individuals) {
        for (Individual current : individuals) {
            int minCommonHabits = Integer.MAX_VALUE;
            Individual bestMatch = null;

            for (Individual other : individuals) {
                if (!current.equals(other)) {
                    int count = countCommonHabits(current.getHabits(), other.getHabits());
                    if (count < minCommonHabits) {
                        minCommonHabits = count;
                        bestMatch = other;
                    }
                }
            }
            if (bestMatch != null) {
                current.setMatchWith(bestMatch);
            } else {
                throw new RuntimeException("No match found for individual!");
            }
        }
    }

    private int countCommonHabits(List<String> habits1, List<String> habits2) {
        Set<String> currentHabits = new HashSet<>(habits1);
        Set<String> otherHabits = new HashSet<>(habits2);
        currentHabits.retainAll(otherHabits);
        return currentHabits.size();
    }
}
