package org.v1.showDown;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public ShowDownResult showDown(Card otherCard) {
        int rankCompare = this.rank.ordinal() - otherCard.rank.ordinal();
        if (rankCompare != 0) {
            return rankCompare > 0 ? ShowDownResult.BIGGER : ShowDownResult.SMALLER;
        } else {
            int suitCompare = this.suit.ordinal() - otherCard.suit.ordinal();
            return suitCompare > 0 ? ShowDownResult.BIGGER : ShowDownResult.SMALLER;
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
