package org.v2;

import java.util.ArrayList;

public class PokerDeck extends Deck<PokerCard> {

    public PokerDeck() {
        super(new ArrayList<>());
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new PokerCard(suit, rank));
            }
        }
    }
}
