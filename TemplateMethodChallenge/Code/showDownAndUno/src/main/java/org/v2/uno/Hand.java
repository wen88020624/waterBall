package org.v2.uno;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new LinkedList<>();
    }

    public int size() {
        return this.cards.size();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public Optional<Card> getShowCard(Card topCard) {
        for (Card card : cards) {
            if (matchNumber(topCard, card) || matchColor(topCard, card)) {
                cards.remove(card);
                return Optional.of(card);
            }
        }
        return Optional.empty();
    }

    public List<Card> getCards() {
        return cards;
    }

    private boolean matchColor(Card topCard, Card card) {
        return topCard.getColor().equals(card.getColor());
    }

    private boolean matchNumber(Card topCard, Card card) {
        return topCard.getNumber().equals(card.getNumber());
    }
}
