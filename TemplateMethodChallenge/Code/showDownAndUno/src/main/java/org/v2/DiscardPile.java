package org.v2;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile<T extends Card> {
    private List<T> cards;


    public void addTop(T card) {
        cards.add(card);
    }

    public List<T> getTopCards(int number) {
        if (number <= 0 || number > cards.size()) {
            throw new IllegalArgumentException("Invalid number of cards requested.");
        }
        int fromIndex = cards.size() - number;
        int toIndex = cards.size();

        return new ArrayList<>(cards.subList(fromIndex, toIndex));
    }

    public List<T> getCards() {
        return cards;
    }
}
