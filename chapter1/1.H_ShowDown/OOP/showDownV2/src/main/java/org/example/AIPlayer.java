package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class AIPlayer extends Player{
    @Override
    public void nameHimself() {
        Random random = new Random();
        setName("AIPlayer" + random.nextInt(9999));
        System.out.println("You have named yourself: " + this.getName());
    }

    @Override
    protected Optional<Card> showCard() {
        if (this.getHand().size() == 0) {
            return Optional.empty();

        } else if (this.getHand().size() == 1) {
            return Optional.of(getHand().getCards().remove(0));

        } else {
            Random random = new Random();
            System.out.println("hand: " + this.getHand().printHand() + " , handSize: "+ getHand().getCards().size() + ", showCardIndex: " + random.nextInt(getHand().getCards().size() - 1));
            int cardIndex = random.nextInt(getHand().getCards().size() - 1);
            return Optional.of(getHand().getCards().remove(cardIndex));
        }

    }

    @Override
    protected boolean makeDecision() {
        if (hasUsedExchangeHands) {
            return false;
        }
        Random random = new Random();
        boolean decision = random.nextBoolean();
        System.out.println("P" + getId() + ", name: " + getName() + " , make decision: " + decision);
        return decision;
    }

    @Override
    protected Player chooseExchangee(List<Player> players) {
        List<Player> otherPlayers = players.stream()
                .filter(player -> player.getId() != this.getId())
                .toList();

        Random random = new Random();
        Player exchangee = otherPlayers.get(random.nextInt(3));
        System.out.println("Choose exchangee: P" + exchangee.getId() + " , name: " + exchangee.getName());
        return exchangee;
    }
}
