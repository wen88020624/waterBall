package org.v1.uno;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private List<Card> discardPile;

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card drawCard() {
        if (!this.cards.isEmpty()) {
            return cards.remove(cards.size() - 1);

        } else {
            Card topCard = discardPile.remove(discardPile.size() - 1);
            Collections.shuffle(discardPile);
            cards.addAll(discardPile);

            return cards.remove(cards.size() - 1);
        }
    }
}
