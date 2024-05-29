package org.v1.showDown;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>(13);

    public void addToHand(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
