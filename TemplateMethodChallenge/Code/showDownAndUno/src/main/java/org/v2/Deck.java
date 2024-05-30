package org.v2;


import java.util.Collections;
import java.util.List;

public class Deck<T extends Card> {
    protected List<T> deck;

    public Deck(List<T> cards) {
        this.deck = cards;
    }

    protected void shuffle() {
        Collections.shuffle(deck);
    }

    protected T drawCard() {
        return deck.remove(deck.size() - 1);
    }
}
