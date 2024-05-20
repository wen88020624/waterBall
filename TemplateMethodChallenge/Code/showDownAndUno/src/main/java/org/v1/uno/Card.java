package org.v1.uno;

public class Card {
    private Color color;
    private Number number;

    public Card(Number number, Color color) {
        this.color = color;
        this.number = number;
    }

    public String toString() {
        return color + " of " + number;
    }

    public Color getColor() {
        return color;
    }

    public Number getNumber() {
        return number;
    }
}
