package org.v2;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public static List<Card> createCards(CardType type) {
        List<Card> cards = new ArrayList<>();
        switch (type) {
            case UNO:
                for (Color color : Color.values()) {
                    for (Number number : Number.values()) {
                        cards.add(new UnoCard(number, color));
                    }
                }
                break;
            case POKER:
                for (Suit suit : Suit.values()) {
                    for (Rank rank : Rank.values()) {
                        cards.add(new PokerCard(suit, rank));
                    }
                }
                break;
        }
        return cards;
    }
}
