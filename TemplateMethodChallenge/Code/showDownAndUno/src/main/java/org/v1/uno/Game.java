package org.v1.uno;

import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players;

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

        discardPile.add(deck.drawCard())
        while(1)
            for i=1; i<=4; i++
        discardPile.addFirst(p[i].showCard(discardPile[0]))
        if (p[i].hand.size()==0)
            winner = p[i]
        break
    }
}
