package org.v2.uno;

import org.v2.DiscardPile;
import org.v2.GameTemplate;
import org.v2.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Uno extends GameTemplate<UnoCard> {

    public Uno() {
        super();
    }

    @Override
    protected Player<UnoCard> createPlayer() {
        var random = new Random();
        if (random.nextBoolean()) {
            return new HumanUnoPlayer();
        } else {
            return new AIUnoPlayer();
        }
    }

    @Override
    protected Deck<UnoCard> createDeck() {
        return new UnoDeck();
    }

    @Override
    protected DiscardPile<UnoCard> createDiscardPile() {
        return new UnoDiscardPile();
    }

    @Override
    protected void playGame() {
        Player<UnoCard> winner = null;
        boolean gameWon = false;
        while(!gameWon) {
            for (Player<UnoCard> player: players) {
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
        discardPile.addTop(deck.drawCard());
    }

    @Override
    protected int getHandSize() {
        return 5;
    }

    private void playerTurn(Player<UnoCard> player) {
        List<UnoCard> topCard = discardPile.getTopCards(1);
        discardPile.addTop(player.showCard(topCard.get(0), deck));

        var discardPileDesc = discardPile.getCards().stream()
                        .map(UnoCard:: toString)
                                .collect(Collectors.joining(", "));
        System.out.println("discardPile: " + discardPileDesc);
    }

    private boolean isPlayerWon(Player<UnoCard> player) {
        return player.getHand().size() == 0;
    }
}
