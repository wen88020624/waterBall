package uno;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cardStack = new Stack<>();

    public static Deck standard40UnoCards() {
        Deck deck = new Deck();
        for (Card.Color color : Card.Color.values()) {
            for (Card.Number number : Card.Number.values()) {
                deck.push(new Card(color, number));
            }
        }
        return deck;
    }

    public void push(Card card) {
        this.cardStack.push(card);
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public Card draw() {
        return cardStack.pop();
    }

    public Card peek() {
        return cardStack.peek();
    }
}
