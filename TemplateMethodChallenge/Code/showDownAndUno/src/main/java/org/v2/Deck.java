package org.v2;

import java.util.Collections;
import java.util.List;

public class Deck<T extends Card> {
    protected List<T> cards;

    public Deck(List<T> cards) {
        this.cards = cards;
    }

    protected void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Deck finish shuffling");
    }

    protected T drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards in the deck");
        }
        return cards.remove(0);
    }
}
