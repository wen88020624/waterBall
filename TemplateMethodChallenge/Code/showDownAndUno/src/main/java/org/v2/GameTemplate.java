package org.v2;


import java.util.List;
import java.util.stream.Collectors;

public abstract class GameTemplate {
    protected Deck deck;
    protected List players;
    protected DiscardPile discardPile;

    protected void start() {
        nameHimself();

        prepareGame();

        drawCard();

        playGame();
    }

    protected void nameHimself() {
        int index = 1;
        for (ShowDownPlayer player : players) {
            player.nameHimself("P" + index);
            System.out.println("P" + index +"'s name: " + player.getName());
            index++;
        }
    }

    protected void prepareGame() {
        deck.shuffle();
    }

    protected void drawCard() {
        for (ShowDownPlayer player : players) {
            while (player.getHand().size() < getHandSize()) {
                player.getHand().add(deck.drawCard());
            }

            String handDes = player.getHand().getCards().stream()
                    .map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " finished drawCard: " + handDes);
        }
    }

    protected abstract void playGame();

    protected abstract int getHandSize();
}
