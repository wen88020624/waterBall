package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AIPlayer extends Player{
    @Override
    protected void nameHimself() {
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
                .filter(player -> player.getPlayerNumber() == playerNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    @Override
    protected void choosePlayer() {
        Random random = new Random();
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            number = 1 + random.nextInt(4);

            if (!chosenPlayers.contains(number)) {
                setPlayerNumber(number);
                chosenPlayers.add(number);
                validInput = true;
            }
        }

        System.out.println("AI has chosen player: P" + number);
    }
}
