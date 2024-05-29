package org.v2.uno;

import java.util.Optional;
import java.util.stream.Collectors;

public class Uno extends GameTemplate {
    private DiscardPile discardPile;

    public Uno() {
        super();
        this.discardPile = new DiscardPile();
        this.deck = new Deck(discardPile);
    }

    @Override
    protected void playGame() {
        Player winner = null;
        boolean gameWon = false;
        while(!gameWon) {
            for (Player player : players) {
                Card topCard = discardPile.getTopCard();
                discardPile.addTop(player.showCard(topCard, this.deck));

                var discardPileDesc = discardPile.getCards().stream()
                        .map(Card :: toString)
                        .collect(Collectors.joining(", "));
                System.out.println("discardPile: " + discardPileDesc);

                if (isPlayerWon(player)) {
                    winner = player;
                    gameWon = true;
                    break;
                }
            }
        }

        System.out.println("winner is " + winner.getName());
    }

    private boolean isPlayerWon(org.v2.uno.Player player) {
        return player.getHand().size() == 0;
    }

    @Override
    protected int getHandSize() {
        return 5;
    }

    @Override
    protected void prepareGame() {
        deck.shuffle();

        discardPile.addTop(Optional.of(deck.drawCard()));
    }
}
