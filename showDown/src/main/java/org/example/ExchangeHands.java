package org.example;

import java.util.List;

public class ExchangeHands {
    private final int roundsCountDown;
    private final Player leftPlayer;
    private final Player rightPlayer;

    public ExchangeHands(Player leftPlayer, Player rightPlayer) {
        this.roundsCountDown = 3;
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
    }

    public void exchangeBack() {
        var tempHands = leftPlayer.getHand();
        leftPlayer.setHand(rightPlayer.getHand());
        rightPlayer.setHand(tempHands);
        leftPlayer.setExchangeHands(null);
        rightPlayer.setExchangeHands(null);
    }

    public void checkRemainTerms() {
        if (this.roundsCountDown == 0) {
            exchangeBack();
        }
    }
}
