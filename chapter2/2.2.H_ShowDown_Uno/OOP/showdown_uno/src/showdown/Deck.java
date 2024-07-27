package showdown;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardStack = new Stack<>();

    public static Deck standard52Cards() {
        Deck deck = new Deck();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.push(new Card(suit, rank));
            }
        }
        return deck;
    }

    public void push(Card card) {
        this.cardStack.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public int size() {
        return cardStack.size();
    }

    public Card draw() {
        return cardStack.pop();
    }
}
