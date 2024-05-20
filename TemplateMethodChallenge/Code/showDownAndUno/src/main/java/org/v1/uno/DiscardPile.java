package org.v1.uno;

import java.util.Collections;
import java.util.List;

public class DiscardPile {
    private List<Card> cards;
    private Deck deck;

    public void shuffleAndAddToDeck() {
        Card topCard = cards.remove(cards.size() - 1);
        Collections.shuffle(cards);
        deck.getCards().addAll(cards);
        cards.clear();
        cards.add(topCard);
    }

    public void addTop(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        return cards.get(cards.size() - 1);
    }
}
