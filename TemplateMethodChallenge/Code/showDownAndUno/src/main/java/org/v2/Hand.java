package org.v2;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand<T extends Card> {
    protected List<T> cards = new ArrayList<>();

    public void add(T card) {
        this.cards.add(card);
    }

    public int size() {
        return this.cards.size();
    }

    public List<T> getCards() {
        return cards;
    }
}
