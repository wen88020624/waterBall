package v2;

import java.util.List;

public class HabitBasedReverse implements MatchStrategy {
    @Override
    public void match(Individual matcher, List<Individual> individuals) {
        Individual minInterest = null;
        for (Individual candidate : individuals) {
            if (matcher.equals(candidate)) {
                continue;
            }
            if (minInterest == null
                    || matcher.getInterestOverlapWith(candidate) < matcher.getInterestOverlapWith(minInterest)) {
                minInterest = candidate;
            }
        }
        matcher.match(minInterest);
        System.out.println(matcher.getIntro() + " match " + matcher.getMatchPerson().getIntro());
    }
}
