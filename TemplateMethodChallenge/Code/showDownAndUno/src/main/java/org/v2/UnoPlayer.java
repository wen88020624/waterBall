package org.v2;

import java.util.Optional;
import java.util.stream.Collectors;

public class UnoPlayer extends Player<UnoHand> {

    public Optional<UnoCard> showCard(UnoCard topCard, UnoDeck deck) {
        Optional<UnoCard> showCard = hand.getShowCard(topCard);

        if (showCard.isPresent()) {
            var handDes = hand.getCards().stream()
                    .map(UnoCard:: toString)
                    .collect(Collectors.joining(", "));
            System.out.println(name + " , hand: " + handDes + "topCard: " + topCard + " , showCard: " + showCard.toString());
            return showCard;

        } else {
            var drawCard = deck.drawCard();
            hand.add(drawCard);
            var handDes = hand.getCards().stream()
                    .map(UnoCard:: toString)
                    .collect(Collectors.joining(", "));
            System.out.println(name + " , hand: " + handDes + " , drawCard: " + drawCard.toString());
            return Optional.empty();
        }

    }

    public UnoHand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

}
