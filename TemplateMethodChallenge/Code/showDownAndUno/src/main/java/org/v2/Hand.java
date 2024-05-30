package org.v2;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> {
    private final List<T> cards = new ArrayList<>();

    public void add(T card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public List<T> getCards() {
        return cards;
    }
}
