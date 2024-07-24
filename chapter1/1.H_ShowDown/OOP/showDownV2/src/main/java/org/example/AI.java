package main.java.org.example;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.String.format;

public class AI extends Player{
    private static final Random random = new Random();
    @Override
    public void nameHimself(int order) {
        setName(format("AI-%d", order));
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
