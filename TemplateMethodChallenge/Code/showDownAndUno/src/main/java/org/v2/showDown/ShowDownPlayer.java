package org.v2.showDown;

import org.v2.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ShowDownPlayer extends Player<ShowDownHand> {
    private Integer point = 0;
    private ExchangeHands exchangee;
    private final List<ExchangeHands> exchanger = new ArrayList<>(3);
    private boolean hasExchangedHands = false;

    public void takeTern(List<ShowDownPlayer> players, HashMap<ShowDownPlayer, PokerCard> playersShowCardEachRound) {
        var otherPlayers = getOtherPlayers(players);
        makeExchangeHandsDecision(otherPlayers);
        playersShowCardEachRound.put(this, this.showCard());
        countDownRoundsAndExchangeBack(players);
    }

    private void countDownRoundsAndExchangeBack(List<ShowDownPlayer> players) {
        players.forEach(player -> {
            if (exchangee != null) {
                exchangee.countDownRounds();
                exchangee.exchangeBackIfRoundsCountDownEqualZero();
            }
        });
    }

    private List<ShowDownPlayer> getOtherPlayers(List<ShowDownPlayer> players) {
        var otherPlayers = new ArrayList<ShowDownPlayer>(players.size());
        players.forEach(player -> {
            if (!player.equals(this)) {
                otherPlayers.add(player);
            }
        });
        return otherPlayers;
    }

    public void makeExchangeHandsDecision(List<ShowDownPlayer> otherPlayers) {
        var isUseExchangeHands = getDecisionByRandom();
        System.out.println("player: "+this.getName()+". isUseExchangeHands: "+isUseExchangeHands);
        if (isUseExchangeHands) {
            var exchangee = chooseExchangee(otherPlayers);
            System.out.println("Exchanger: "+this.getName()+", Exchangee: "+exchangee.getName());
            exchangeHand(exchangee);
        }
    }

    private boolean getDecisionByRandom() {
        var random = new Random();
        return !this.hasExchangedHands && this.exchangee == null && random.nextBoolean();
    }

    private ShowDownPlayer chooseExchangee(List<ShowDownPlayer> players) {
        Random random = new Random();
        int index = random.nextInt(players.size());
        return players.get(index);
    }

    private void exchangeHand(ShowDownPlayer exchangee) {
        var exchangeHands = new ExchangeHands(this, exchangee);
        this.setExchangee(exchangeHands);
        exchangee.addExchanger(exchangeHands);
        this.setHasExchangedHands(true);

        System.out.println("before change exchanger: "+this.getName()+", hand: "+this.getHand()+
                "; exchangee: "+exchangee.getName()+", hand: "+exchangee.getHand());
        var tempHand = this.getHand();
        this.setHand(exchangee.getHand());
        exchangee.setHand(tempHand);
        System.out.println("after change exchanger: "+this.getName()+", hand: "+this.getHand()+
                "; exchangee: "+exchangee.getName()+", hand: "+exchangee.getHand());
    }

    public PokerCard showCard() {
        var random = new Random();
        var index = random.nextInt(this.getHand().getCards().size());
        return this.getHand().getCards().get(index);
    }

    public void gainPoint() {
        this.setPoint(this.getPoint() + 1);
    }

    public void setPoint(Integer point) {
        if (point < 0) {
            throw new IllegalArgumentException();
        }
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public Integer getPoint() {
        return point;
    }

    public ShowDownHand getHand() {
        return hand;
    }

    public void setHand(ShowDownHand hand) {
        this.hand = hand;
    }

    public void setExchangee(ExchangeHands exchangee) {
        this.exchangee = exchangee;
    }

    public void addExchanger(ExchangeHands exchanger) {
        this.exchanger.add(exchanger);
    }

    public List<ExchangeHands> getExchanger() {
        return exchanger;
    }

    public void setHasExchangedHands(boolean hasExchangedHands) {
        this.hasExchangedHands = hasExchangedHands;
    }
}
