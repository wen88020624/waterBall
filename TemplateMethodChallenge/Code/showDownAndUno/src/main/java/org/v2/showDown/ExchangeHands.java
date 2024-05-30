package org.v2.showDown;

public class ExchangeHands {
    private int roundsCountDown;
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

    public Player getExchanger() {
        return exchanger;
    }
}
