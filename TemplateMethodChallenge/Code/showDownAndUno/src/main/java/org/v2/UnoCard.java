package org.v2;

public class UnoCard extends Card{
    private Color color;
    private Number number;

    public UnoCard(Number number, Color color) {
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
