package main.java.org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (cards.size() >= 13) {
            throw new IllegalStateException("The hand's size must not exceed 13.");
        }
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
