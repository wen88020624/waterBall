package v1;

import java.util.List;

public class MatchMakingSystem {
    private List<Individual> individuals;

    public MatchMakingSystem(List<Individual> individuals) {
        this.individuals = individuals;
    }

    public void match() {
        for (Individual matcher : individuals) {
            String matchStrategy = matcher.getMatchStrategy();

            if (matchStrategy == "Distance-Based") {
                //配對與自己距離最近的對象（距離相同則選擇編號較小的那位）。
                Individual closetPerson = null;
                for (Individual candidate : individuals) {
                    if (closetPerson == null
                            || matcher.distanceTo(candidate) < matcher.distanceTo(closetPerson)) {
                        closetPerson = candidate;
                    }
                }
                matcher.match(closetPerson);

            } else if (matchStrategy == "Distance-Based-Reverse") {
                //配對與自己距離最遠的對象（距離相同則選擇編號較小的那位）。
                Individual furthestPerson = null;
                for (Individual candidate : individuals) {
                    if (furthestPerson == null
                            || matcher.distanceTo(candidate) > matcher.distanceTo(furthestPerson)) {
                        furthestPerson = candidate;
                    }
                }
                matcher.match(furthestPerson);

            } else if (matchStrategy == "Habit-Based") {
                //配對與自己興趣擁有最大交集量的對象（興趣交集量相同則選擇編號較小的那位）。

            } else if (matchStrategy == "Habit-Based-Reverse") {
                //配對與自己興趣擁有最小交集量的對象（興趣交集量相同則選擇編號較小的那位）。
            }
        }
    }
}
