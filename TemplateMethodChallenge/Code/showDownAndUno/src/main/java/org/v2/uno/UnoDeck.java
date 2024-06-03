package org.v2.uno;

import java.util.ArrayList;
import java.util.Collections;

public class UnoDeck extends Deck<UnoCard> {
    private UnoDiscardPile discardPile;

    public UnoDeck() {
        super(new ArrayList<>());
        for (Number number : Number.values()) {
            for (Color color : Color.values()) {
                cards.add(new UnoCard(number, color));
            }
        }
    }

    @Override
    public UnoCard drawCard() {
        if (!this.cards.isEmpty()) {
            System.out.println("Deck.size(): " + cards.size());
            return cards.remove(cards.size() - 1);

        } else {
            System.out.println("Deck is empty");
            shuffleAndAddToDeck();
            return cards.remove(cards.size() - 1);
        }
    }

    private void shuffleAndAddToDeck() {
        UnoCard topCard = discardPile.getCards().remove(discardPile.getCards().size() - 1);
        Collections.shuffle(discardPile.getCards());
        cards.addAll(discardPile.getCards());
        discardPile.getCards().clear();
        discardPile.getCards().add(topCard);
        System.out.println("discardPile shuffle And Add To Deck, deck: " + cards + ", discardPile: " + discardPile);
    }

    public void setDiscardPile(UnoDiscardPile discardPile) {
        this.discardPile = discardPile;
    }
}
