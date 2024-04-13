package org.v1;

import java.util.List;

public class DistanceBasedReverse implements MatchmakingStrategy {
    @Override
    public void match(List<Individual> individuals) {
        for (Individual current : individuals) {
            double maxDistance = Double.MIN_VALUE;
            Individual closetMatch = null;

            for (Individual other : individuals) {
                if (!current.equals(other)) {
                    double distance = current.getCoord().distanceTo(other.getCoord());
                    if (distance > maxDistance || (distance == maxDistance && (other.getId() < closetMatch.getId()))) {
                        maxDistance = distance;
                        closetMatch = other;
                    }
                }
            }
            if (closetMatch != null) {
                current.setMatchWith(closetMatch);
            } else {
                throw new RuntimeException("No match found for individual!");
            }
        }
    }
}
