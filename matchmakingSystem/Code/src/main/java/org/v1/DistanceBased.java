package org.v1;

import java.util.List;

public class DistanceBased implements MatchmakingStrategy {

    @Override
    public void match(List<Individual> individuals) {
        for (Individual current : individuals) {
            double minDistance = Double.MAX_VALUE;
            Individual closetMatch = null;

            for (Individual other : individuals) {
                if (!current.equals(other)) {
                    double distance = current.getCoord().distanceTo(other.getCoord());
                    if (distance < minDistance || (distance == minDistance && (other.getId() < closetMatch.getId()))) {
                        minDistance = distance;
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
