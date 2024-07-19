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
        SPADE('♠'), HEART('♥'), DIAMOND('♦'), CLUB('♣');

        private final char representation;

        Suit(char representation) {
            this.representation = representation;
        }

        @Override
        public String toString() {
            return String.valueOf(representation);
        }
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
}
