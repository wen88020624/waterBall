package org.v1.uno;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> deck;
    private DiscardPile discardPile;

    public Deck(DiscardPile discardPile) {
        this.deck = new LinkedList<>();
        for (Number number : Number.values()) {
            for (Color color : Color.values()) {
                this.deck.add(new Card(number, color));
            }
        }
        this.discardPile = discardPile;
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
        System.out.println("Deck finish shuffling");
    }

    public Card drawCard() {
        if (!this.deck.isEmpty()) {
            System.out.println("Deck.size(): " + deck.size());
            return deck.remove(deck.size() - 1);

        } else {
            System.out.println("Deck is empty");
            shuffleAndAddToDeck();
            return deck.remove(deck.size() - 1);
        }
    }

    public void shuffleAndAddToDeck() {
        Card topCard = discardPile.getCards().remove(discardPile.getCards().size() - 1);
        Collections.shuffle(discardPile.getCards());
        deck.addAll(discardPile.getCards());
        discardPile.getCards().clear();
        discardPile.getCards().add(topCard);
        System.out.println("discardPile shuffle And Add To Deck, deck: " + deck + ", discardPile: " + discardPile);
    }
}
