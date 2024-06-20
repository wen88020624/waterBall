package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String printHand() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }
}
