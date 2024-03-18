package org.example;

import java.util.List;

public class Hand {
    private List<Card> hand;

    public void addToHand(Card card) {
        hand.add(card);
    }

    public int size() {
        return hand.size();
    }

    public List<Card> getHand() {
        return hand;
    }
}
