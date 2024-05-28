package org.v2.uno;

import java.util.Optional;
import java.util.stream.Collectors;

public class Player {

    private String name;
    private Hand hand;

    public Player() {
        this.hand = new Hand();
    }

    public Optional<Card> showCard(Card topCard, Deck deck) {
        Optional<Card> showCard = hand.getShowCard(topCard);

        if (showCard.isPresent()) {
            var handDes = hand.getCards().stream()
                    .map(Card :: toString)
                    .collect(Collectors.joining(", "));
            System.out.println(name + " , hand: " + handDes + "topCard: " + topCard + " , showCard: " + showCard.toString());
            return showCard;

        } else {
            var drawCard = deck.drawCard();
            hand.add(drawCard);
            var handDes = hand.getCards().stream()
                    .map(Card :: toString)
                    .collect(Collectors.joining(", "));
            System.out.println(name + " , hand: " + handDes + " , drawCard: " + drawCard.toString());
            return Optional.empty();
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
