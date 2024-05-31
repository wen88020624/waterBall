package org.v2;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class Uno extends GameTemplate {

    public Uno() {
        this.players = new LinkedList<>();
        for (int i=1; i<=4; i++) {
            var random = new Random();
            if (random.nextBoolean()) {
                this.players.add(new AIUnoPlayer());
            } else {
                this.players.add(new HumanUnoPlayer());
            }
        }
        this.deck = new Deck<>(CardFactory.createCards(CardType.UNO));
        this.discardPile = new DiscardPile<UnoCard>();
    }

    @Override
    protected void playGame() {
        UnoPlayer winner = null;
        boolean gameWon = false;

        while(!gameWon) {
            for (Object player : players) {
                UnoCard topCard = (UnoCard) discardPile.getTopCards(1).get(0);
                discardPile.addTop(player.showCard(topCard, this.deck));

                var discardPileDesc = discardPile.getCards().stream()
                        .map(UnoCard:: toString)
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

    private boolean isPlayerWon(ShowDownPlayer player) {
        return player.getHand().size() == 0;
    }

    @Override
    protected int getHandSize() {
        return 5;
    }

    @Override
    protected void prepareGame() {
        deck.shuffle();

        discardPile.addTop(deck.drawCard());
    }
}
