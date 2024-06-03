package org.v2;

import org.v2.uno.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GameTemplate<T extends Card> {
    protected Deck<T> deck;
    protected List<Player<T>> players;
    protected DiscardPile<T> discardPile;

    public GameTemplate() {
        this.players = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            this.players.add(createPlayer());
        }

        this.deck = createDeck();

        this.discardPile = createDiscardPile();
    }

    protected abstract Player<T> createPlayer();

    protected abstract Deck<T> createDeck();

    protected abstract DiscardPile<T> createDiscardPile();

    public void start() {
        nameHimself();

        prepareGame();

        drawCard();

        playGame();
    }

    protected void nameHimself() {
        int index = 1;
        for (Player<T> player : players) {
            player.nameHimself("P" + index);
            System.out.println("P" + index +"'s name: " + player.getName());
            index++;
        }
    }

    protected void prepareGame() {
        deck.shuffle();
    }

    protected void drawCard() {
        for (Player<T> player : players) {
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
