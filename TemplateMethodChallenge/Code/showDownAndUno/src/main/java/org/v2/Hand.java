package org.v2;

import java.util.List;

public class Hand <T extends Card> {

    protected List<T> cards;

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
