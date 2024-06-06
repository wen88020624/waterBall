package org.example;

import java.util.List;

public class ExchangeHand {
    private final Player exchanger;
    private final Player exchangee;
    private int remainTern = 3;

    public ExchangeHand(Player exchanger, Player exchangee) {
        this.exchanger = exchanger;
        this.exchangee = exchangee;
    }

    public void exchangeHandsBack() {
        List<Card> temp = exchanger.getHand().getCards();
        exchanger.getHand().setCards(exchangee.getHand().getCards());
        exchangee.getHand().setCards(temp);

        exchanger.getExchangeHands().remove(this);
        exchangee.getExchangeHands().remove(this);
    }
}
