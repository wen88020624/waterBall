package challenge.secondTry;

import java.util.List;

public class ExchangeHands {
    private final int remainTerms;
    private final Player leftPlayer;
    private final Player rightPlayer;

    public ExchangeHands(Player leftPlayer, Player rightPlayer) {
        this.remainTerms = 3;
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
    }

    public void finishExchangeHands() {
        List<Card> tempHands = leftPlayer.getHands();
        leftPlayer.setHands(rightPlayer.getHands());
        rightPlayer.setHands(tempHands);
        leftPlayer.setExchangeHands(null);
        rightPlayer.setExchangeChance(null);
    }

    public void checkRemainTerms() {
        if (this.remainTerms == 0) {
            finishExchangeHands();
        }
    }
}
