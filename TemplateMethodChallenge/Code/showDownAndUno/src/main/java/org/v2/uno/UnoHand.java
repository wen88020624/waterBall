package org.v2.uno;

import org.v2.Hand;

import java.util.Optional;

public class UnoHand extends Hand<UnoCard> {

    public Optional<UnoCard> getShowCard(UnoCard topCard) {
        for (UnoCard card : cards) {
            if (card.isMatch(topCard)) {
                cards.remove(card);
                return Optional.of(card);
            }
        }
        return Optional.empty();
    }
}
