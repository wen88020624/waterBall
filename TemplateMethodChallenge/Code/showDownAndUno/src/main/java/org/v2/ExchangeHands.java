package org.v2;

public class ExchangeHands {
    private int roundsCountDown;
    private final ShowDownPlayer exchanger;
    private final ShowDownPlayer exchangee;

    public ExchangeHands(ShowDownPlayer exchanger, ShowDownPlayer exchangee) {
        this.roundsCountDown = 3;
        this.exchanger = exchanger;
        this.exchangee = exchangee;
    }

    public void exchangeBack() {
        var tempHands = exchanger.getHand();
        exchanger.setHand(exchangee.getHand());
        exchangee.setHand(tempHands);

        exchanger.setExchangee(null);
        exchangee.getExchanger().removeIf(exchange -> exchange.getExchanger().equals(exchanger));
    }

    public void exchangeBackIfRoundsCountDownEqualZero() {
        if (this.roundsCountDown == 0) {
            exchangeBack();
        }
    }

    public void countDownRounds() {
        this.roundsCountDown = this.roundsCountDown - 1;
    }

    public ShowDownPlayer getExchanger() {
        return exchanger;
    }
}
