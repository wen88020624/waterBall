package org.v1.uno;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    private void shuffle() {
        Collections.shuffle(this.cards);
    }

    private Card drawCard() {
        if (!this.cards.isEmpty()) {
            return cards.remove(cards.size() - 1);

        } else {

        }
    }
}
