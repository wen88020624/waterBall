package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AIPlayer extends Player{
    @Override
    public void nameHimself() {
        Random random = new Random(4);
        setName("AIPlayer" + random + 1);
    }

    @Override
    protected Optional<Card> showCard() {
        Random random = new Random();
        int cardIndex = random.nextInt(getHand().getCards().size() - 1);
        return Optional.of(getHand().getCards().get(cardIndex));
    }

    @Override
    protected Player chooseExchangee(List<Player> players) {
        Random random = new Random();
        int playerNumber = 1 + random.nextInt(4);
        return players.stream()
                .filter(player -> player.playerNumber == playerNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }
}
