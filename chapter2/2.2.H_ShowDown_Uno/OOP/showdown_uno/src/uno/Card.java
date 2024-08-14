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
        ZERO(0), ONE(1), TWO(2), THREE(3)
        , FOUR(4), FIVE(5), SIX(6), SEVEN(7)
        , EIGHT(8), NINE(9);

        private final int representation;

        Number(int representation) {
            this.representation = representation;
        }
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
