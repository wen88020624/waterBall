package org.v1.uno;

import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players;
    private DiscardPile discardPile;

    public void start() {
        for (Player player : players) {
            int index = 1;
            player.nameHimself("P" + index);
            index++;
        }

        deck.shuffle();

        for (Player player : players) {
            while(player.getHand().size() <= 5)
                player.getHand().add(deck.drawCard());
        }

        discardPile.addTop(deck.drawCard());

        Player winner = null;
        while(true) {
            for (Player player : players) {
                Card topCard = discardPile.getTopCard();
                discardPile.addTop(player.showCard(topCard));
                if (player.getHand().size() == 0) {
                    winner = player;
                    break;
                }
            }
        }

        System.out.println(winner.getName());
    }
}
