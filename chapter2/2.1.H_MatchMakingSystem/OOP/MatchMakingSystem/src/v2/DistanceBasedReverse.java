package v2;

import java.util.List;

public class DistanceBasedReverse implements MatchStrategy {
    @Override
    public void match(Individual matcher, List<Individual> individuals) {
        Individual furthestPerson = null;
        for (Individual candidate : individuals) {
            if (matcher.equals(candidate)) {
                continue;
            }
            if (furthestPerson == null
                    || matcher.distanceTo(candidate) > matcher.distanceTo(furthestPerson)) {
                furthestPerson = candidate;
            }
        }
        matcher.match(furthestPerson);
        System.out.println(matcher.getIntro() + " match " + matcher.getMatchPerson().getIntro());
    }
}
