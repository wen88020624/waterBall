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

    public Card get(int index) {
        return cards.get(index);
    }

    public Card show(int index) {
        return cards.remove(index);
    }
}
