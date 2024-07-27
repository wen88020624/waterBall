package showdown;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public int size() {
        return cards.size();
    }

    public void addHand(Card card) {
        this.cards.add(card);
    }
}
