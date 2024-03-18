package org.example;

public class ExchangeHands {
    private final int roundsCountDown;
    private final Player exchanger;
    private final Player exchangee;

    public ExchangeHands(Player exchanger, Player exchangee) {
        this.roundsCountDown = 3;
        this.exchanger = exchanger;
        this.exchangee = exchangee;
    }

    public void exchangeBack() {
        var tempHands = exchanger.getHand();
        exchanger.setHand(exchangee.getHand());
        exchangee.setHand(tempHands);
        exchanger.setExchangee(null);
        exchangee.getExchanger().remove(null);
    }

    public void checkRemainTerms() {
        if (this.roundsCountDown == 0) {
            exchangeBack();
        }
    }
}
