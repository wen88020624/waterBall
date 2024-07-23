package v1;

import java.util.List;

public class MatchMakingSystem {
    private List<Individual> individuals;
    private Strategy strategy;

    public MatchMakingSystem(List<Individual> individuals, Strategy strategy) {
        this.individuals = individuals;
        this.strategy = strategy;
    }

    public enum Strategy {
        DISTANCE_BASED, DISTANCE_BASED_REVERSE, HABIT_BASED, HABIT_BASED_REVERSE
    }

    public void match() {
        for (Individual matcher : individuals) {

            if (strategy == Strategy.DISTANCE_BASED) {
                //配對與自己距離最近的對象（距離相同則選擇編號較小的那位）。
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

            } else if (strategy == Strategy.DISTANCE_BASED_REVERSE) {
                //配對與自己距離最遠的對象（距離相同則選擇編號較小的那位）。
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

            } else if (strategy == Strategy.HABIT_BASED) {
                //配對與自己興趣擁有最大交集量的對象（興趣交集量相同則選擇編號較小的那位）。
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

            } else if (strategy == Strategy.HABIT_BASED_REVERSE) {
                //配對與自己興趣擁有最小交集量的對象（興趣交集量相同則選擇編號較小的那位）。
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
            }
            System.out.println(matcher.getIntro() + " match " + matcher.getMatchPerson().getIntro());
        }
    }
}
