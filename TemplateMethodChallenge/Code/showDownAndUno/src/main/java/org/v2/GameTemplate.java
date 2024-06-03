package org.v2;

import org.v1.uno.DiscardPile;

import java.util.ArrayList;
import java.util.List;

public abstract class GameTemplate {
    protected Deck deck;
    protected List<Player> players;
    protected DiscardPile discardPile;

    public GameTemplate() {
        this.players = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            this.players.add(createPlayer());
        }

        this.deck = createDeck();

        this.discardPile = createDiscardPile();
    }

    protected abstract Player createPlayer();

    protected abstract Deck createDeck();

    protected abstract DiscardPile createDiscardPile();

    protected void start() {
        nameHimself();

        prepareGame();

        drawCard();

        playGame();
    }

    protected void nameHimself() {
        int index = 1;
        for (Player player : players) {
            player.nameHimself("P" + index);
            System.out.println("P" + index +"'s name: " + player.getName());
            index++;
        }
    }

    protected void prepareGame() {
        deck.shuffle();
    }

    protected void drawCard() {
        for (Player player : players) {
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
