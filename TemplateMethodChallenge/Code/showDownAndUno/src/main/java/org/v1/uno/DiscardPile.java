package org.v1.uno;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DiscardPile {
    private List<Card> cards;

    public DiscardPile() {
        this.cards = new LinkedList<>();
    }

    public void addTop(Optional<Card> card) {
        if (card.isPresent()){
            cards.add(card.get());
        }
    }

    public Card getTopCard() {
        return cards.get(cards.size() - 1);
    }

    public List<Card> getCards() {
        return cards;
    }
}
