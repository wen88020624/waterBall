package org.v1.uno;

import java.util.List;

public class Hand {
    private List<Card> cards;

    public int size() {
        return this.cards.size();
    }

    public void add(Card card) {
        this.cards.add(card);
    }
}
