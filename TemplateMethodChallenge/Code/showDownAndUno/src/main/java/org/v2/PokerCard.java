package org.v2;

public class PokerCard extends Card{
    private final Rank rank;
    private final Suit suit;

    public PokerCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public ShowDownResult showDown(PokerCard otherCard) {
        int rankCompare = this.rank.ordinal() - otherCard.rank.ordinal();
        if (rankCompare != 0) {
            return rankCompare > 0 ? ShowDownResult.BIGGER : ShowDownResult.SMALLER;
        } else {
            int suitCompare = this.suit.ordinal() - otherCard.suit.ordinal();
            return suitCompare > 0 ? ShowDownResult.BIGGER : ShowDownResult.SMALLER;
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
