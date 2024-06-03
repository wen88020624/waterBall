package org.v2;

import java.util.Optional;

public class UnoHand extends Hand<UnoCard>{

    public Optional<UnoCard> getShowCard(UnoCard topCard) {
        for (UnoCard card : cards) {
            if (matchNumber(topCard, card) || matchColor(topCard, card)) {
                cards.remove(card);
                return Optional.of(card);
            }
        }
        return Optional.empty();
    }

    private boolean matchColor(UnoCard topCard, UnoCard card) {
        return topCard.getColor().equals(card.getColor());
    }

    private boolean matchNumber(UnoCard topCard, UnoCard card) {
        return topCard.getNumber().equals(card.getNumber());
    }
}
