import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.String.format;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class AI extends Player{
    private static final Random random = new Random();
    @Override
    public void nameHimself(int order) {
        setName(format("AI-%d", order));
    }

    @Override
    protected Card showCard() {
        if (getHand().size() == 1) {
            return getHand().get(0);
        }
        return getHand().get(random.nextInt(getHand().size()));
    }

    @Override
    protected Optional<ExchangeHands> makeExchangeHandsDecision() {
        if (hasUsedExchangeHands()) {
            return empty();
        }
        return random.nextBoolean() ? of(randomlyExchangeHands()) : empty();
    }

    private ExchangeHands randomlyExchangeHands() {
        List<Player> players = showDown.getPlayers();
        return new ExchangeHands(this, players.get(random.nextInt(players.size())));
    }
}
