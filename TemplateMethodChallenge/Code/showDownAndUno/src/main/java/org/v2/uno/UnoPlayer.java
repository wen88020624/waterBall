package org.v2.uno;

import org.v2.Hand;
import org.v2.Player;

import java.util.Optional;
import java.util.stream.Collectors;

public class UnoPlayer extends Player<UnoCard> {

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

    @Override
    protected Hand<UnoCard> createHand() {
        return new UnoHand();
    }
}
