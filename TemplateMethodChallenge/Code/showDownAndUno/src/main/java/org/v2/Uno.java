package org.v2;

import java.util.Optional;
import java.util.stream.Collectors;

public class Uno extends GameTemplate {

    public Uno() {
        super();
        Deck<Card> deck = new Deck<>(CardFactory.createCards(CardType.UNO));
        this.discardPile = new DiscardPile();
        this.deck = new Deck(discardPile);
    }

    @Override
    protected void playGame() {
        org.v2.uno.Player winner = null;
        boolean gameWon = false;
        while(!gameWon) {
            for (org.v2.uno.Player player : players) {
                org.v2.uno.Card topCard = discardPile.getTopCard();
                discardPile.addTop(player.showCard(topCard, this.deck));

                var discardPileDesc = discardPile.getCards().stream()
                        .map(Card:: toString)
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

    private boolean isPlayerWon(Player player) {
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
