package org.v2;

import org.v1.uno.DiscardPile;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Uno extends GameTemplate {

    public Uno() {
        super();
    }

    @Override
    protected Player createPlayer() {
        var random = new Random();
        if (random.nextBoolean()) {
            return new HumanShowDownPlayer();
        } else {
            return new AIShowDownPlayer();
        }
    }

    @Override
    protected Deck createDeck() {
        return new UnoDeck();
    }

    @Override
    protected DiscardPile createDiscardPile() {
        return new UnoDiscardPile();
    }

    @Override
    protected void playGame() {
        UnoPlayer winner = null;
        boolean gameWon = false;
        while(!gameWon) {
            for (UnoPlayer player : players) {
                playerTurn(player);
                if (isPlayerWon(player)) {
                    winner = player;
                    gameWon = true;
                    break;
                }
            }
        }
    }

    @Override
    protected void prepareGame() {
        deck.shuffle();
        discardPile.addTop(Optional.of(deck.drawCard()));
    }

    @Override
    protected int getHandSize() {
        return 5;
    }

    private void playerTurn(UnoPlayer player) {
        UnoCard topCard = discardPile.getTopCard();
        discardPile.addTop(player.showCard(topCard, this.deck));

        var discardPileDesc = discardPile.getCards().stream()
                        .map(UnoCard:: toString)
                                .collect(Collectors.joining(", "));
        System.out.println("discardPile: " + discardPileDesc);
    }

    private boolean isPlayerWon(UnoPlayer player) {
        return player.getHand().size() == 0;
    }
}
