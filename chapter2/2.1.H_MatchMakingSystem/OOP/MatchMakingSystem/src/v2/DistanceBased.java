package v2;

import java.util.List;

public class DistanceBased implements MatchStrategy {
    @Override
    public void match(Individual matcher, List<Individual> individuals) {
        Individual closetPerson = null;
        for (Individual candidate : individuals) {
            if (matcher.equals(candidate)) {
                continue;
            }
            if (closetPerson == null
                    || matcher.distanceTo(candidate) < matcher.distanceTo(closetPerson)) {
                closetPerson = candidate;
            }
        }
        matcher.match(closetPerson);
        System.out.println(matcher.getIntro() + " match " + matcher.getMatchPerson().getIntro());
    }
}
