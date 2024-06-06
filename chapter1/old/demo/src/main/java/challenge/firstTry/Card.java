package challenge.firstTry;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int compareTo(Card otherCard) {
        int rankCompare = this.suit.ordinal() - otherCard.suit.ordinal();
        if (rankCompare != 0) {
            return rankCompare;
        }
        rankCompare = this.rank.ordinal() - otherCard.suit.ordinal();
        return rankCompare;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
