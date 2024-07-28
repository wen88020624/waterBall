package showdown;

import java.util.Random;

import static java.lang.String.format;

public class AI extends Player {
    private static final Random random = new Random();

    @Override
    public void nameSelf(int order) {
        setName(format("AI-%d", order));
    }

    @Override
    public Card showCard() {
        if (getHand().size() == 1) {
            return getHand().show(0);
        }
        return getHand().show(random.nextInt(getHand().size()));
    }
}
