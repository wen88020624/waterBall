package uno;

import java.util.Random;

import static java.lang.String.format;

public class AI extends Player {
    private static final Random random = new Random();

    @Override
    public void nameSelf(int order) {
        setName(format("AI-%d", order));
    }

    @Override
    public void takeTurn() {

    }
}
