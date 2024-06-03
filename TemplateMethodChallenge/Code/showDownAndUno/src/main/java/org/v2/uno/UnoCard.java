package org.v2.uno;

import org.v2.Card;

public class UnoCard extends Card {
    private Color color;
    private Number number;

    public UnoCard(Number number, Color color) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return color + " of " + number;
    }

    public boolean isMatch(UnoCard topCard) {
        return this.color.equals(topCard.color) || this.number.equals(topCard.number);
    }
}
