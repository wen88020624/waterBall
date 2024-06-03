package org.v2.uno;

import org.v2.Card;

import java.util.Collections;
import java.util.List;

public class Deck<T extends Card> {
    protected List<T> cards;

    public Deck(List<T> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Deck finish shuffling");
    }

    public T drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards in the deck");
        }
        return cards.remove(0);
    }
}
