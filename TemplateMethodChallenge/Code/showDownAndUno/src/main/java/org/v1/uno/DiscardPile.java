package org.v1.uno;

import java.util.List;

public class DiscardPile {
    private List<Card> cards;

    public void addTop(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        return cards.get(cards.size() - 1);
    }
}
