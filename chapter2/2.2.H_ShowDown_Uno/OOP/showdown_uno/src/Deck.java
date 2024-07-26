import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardStack = new Stack<>();

    public static Deck standard52Cards() {
        Deck deck = new Deck();
        Card.Suit[] suits = Card.Suit.values();
        Card.Rank[] ranks = Card.Rank.values();

        for (Card.Suit suit : suits) {
            for (Card.Rank rank : ranks) {
                deck.push(new Card(rank, suit));
            }
        }
        return deck;
    }

    private void push(Card card) {
        cardStack.push(card);
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
        System.out.println("Finished shuffling cards");
    }

    public Card draw() {
        return cardStack.pop();
    }

    public int size() {
        return cardStack.size();
    }
}
