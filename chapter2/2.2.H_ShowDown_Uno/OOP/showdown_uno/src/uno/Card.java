package uno;

import static java.lang.String.format;

public class Card {
    private final Color color;
    private final Number number;

    public Card(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    public enum Color {
        BLUE, RED, YELLOW, GREEN
    }

    public enum Number {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
    }

    public boolean equalNumber(Card card) {
        return this.number.equals(card.number);
    }

    public boolean equalColor(Card card) {
        return this.color.equals(card.color);
    }

    @Override
    public String toString() {
        return format("%s%s", color, number);
    }
}
