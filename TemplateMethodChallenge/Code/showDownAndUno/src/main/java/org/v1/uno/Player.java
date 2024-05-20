package org.v1.uno;

import java.util.Optional;

public class Player {

    private String name;

    private Hand hand;

    public Card showCard(Card topCard) {
        Optional<Card> card = hand.getShowCard(topCard);
        if (card.isPresent()) {
            return card.get();

        } else {
            hand.add(deck);
        }
    }

    public void nameHimself(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

}
