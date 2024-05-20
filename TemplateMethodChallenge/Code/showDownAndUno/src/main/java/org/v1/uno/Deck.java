package org.v1.uno;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    private DiscardPile discardPile;
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card drawCard() {
        if (!this.cards.isEmpty()) {
            return cards.remove(cards.size() - 1);

        } else {
            discardPile.shuffleAndAddToDeck();
            return cards.remove(cards.size() - 1);
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
