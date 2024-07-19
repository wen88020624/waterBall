package org.example;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JAKE, QUEEN, KING, ACE
    }

    public enum ShowDownResult {
        BIGGER, SMALLER
    }

    public enum Suit {
        CLUB, DIAMAND, HEART, SPADE
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public ShowDownResult showDown(Card otherCard) {
        if (this.rank.ordinal() == otherCard.rank.ordinal()) {
            return this.suit.ordinal() > otherCard.suit.ordinal()
                    ? ShowDownResult.BIGGER : ShowDownResult.SMALLER;
        } else {
            return this.rank.ordinal() > otherCard.rank.ordinal()
                    ? ShowDownResult.BIGGER : ShowDownResult.SMALLER;
        }
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
