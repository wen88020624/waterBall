package challenge.secondTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>(52);

    public Deck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void drawCard(Player player) {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards in the deck");
        }
        List<Card> hands = player.getHands();
        hands.add(cards.get(0));
        cards.remove(0);
        player.setHands(hands);
    }
}
