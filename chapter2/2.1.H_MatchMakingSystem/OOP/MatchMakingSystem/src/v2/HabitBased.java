package v2;

import java.util.List;

public class HabitBased implements MatchMakingStrategy {
    @Override
    public void match(Individual matcher, List<Individual> individuals) {
        Individual maxInterest = null;
        for (Individual candidate : individuals) {
            if (matcher.equals(candidate)) {
                continue;
            }
            if (maxInterest == null
                    || matcher.getInterestOverlapWith(candidate) > matcher.getInterestOverlapWith(maxInterest)) {
                maxInterest = candidate;
            }
        }
        matcher.match(maxInterest);
        System.out.println(matcher.getIntro() + " match " + matcher.getMatchPerson().getIntro());
    }
}
