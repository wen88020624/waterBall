package org.v1.uno;

import java.util.List;
import java.util.Optional;

public class Hand {
    private List<Card> cards;

    public int size() {
        return this.cards.size();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Optional<Card> getShowCard(Card topCard) {
        for (Card card : cards) {
            if (matchNumber(topCard, card) || matchColor(topCard, card)) {
                return Optional.of(card);
            }
        }
        return Optional.empty();
    }

    private boolean matchColor(Card topCard, Card card) {
        return topCard.getColor().equals(card.getColor());
    }

    private boolean matchNumber(Card topCard, Card card) {
        return topCard.getNumber().equals(card.getNumber());
    }
}
