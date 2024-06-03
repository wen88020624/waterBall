package org.v2;

import org.v1.uno.DiscardPile;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UnoDiscardPile extends DiscardPile {
    private List<UnoCard> cards;

    public UnoDiscardPile() {
        this.cards = new LinkedList<>();
    }

    public void addTop(Optional<UnoCard> card) {
        if (card.isPresent()){
            cards.add(card.get());
        }
    }

    public UnoCard getTopCard() {
        return cards.get(cards.size() - 1);
    }

    public List<UnoCard> getCards() {
        return cards;
    }
}
