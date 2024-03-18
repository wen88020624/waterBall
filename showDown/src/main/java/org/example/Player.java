package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private Integer point = 0;

    private Hand hand;

    private ExchangeHands exchangee;

    private List<ExchangeHands> exchanger;
    private Card showCard;
    public void nameHimSelf(String name) {
        this.name = name;
    }

    public void takeTern(List<Player> players, HashMap<Player, Card> playersShowCardEachRound) {
        var otherPlayers = getOtherPlayers(players);
        makeExchangeHandsDecision(otherPlayers);
        playersShowCardEachRound.put(this, this.showCard());
    }

    private List<Player> getOtherPlayers(List<Player> players) {
        var otherPlayers = new ArrayList<Player>(players.size());
        players.forEach(player -> {
            if (!player.equals(this)) {
                otherPlayers.add(player);
            }
        });
        return otherPlayers;
    }

    public void makeExchangeHandsDecision(List<Player> otherPlayers) {
        var isUseExchangeHands = getDecisionByRandom();
        if (isUseExchangeHands) {
            var exhchangee = chooseExchangee(otherPlayers);
            exchangeHand(exhchangee);
        }
    }

    private boolean getDecisionByRandom() {
        var random = new Random();
        return this.exchangee == null && random.nextBoolean();
    }

    private Player chooseExchangee(List<Player> players) {
        Random random = new Random();
        int index = random.nextInt(players.size());
        return players.get(index);
    }

    private void exchangeHand(Player exchangee) {
        var exchangeHands = new ExchangeHands(this, exchangee);
        this.setExchangee(exchangeHands);
        exchangee.addExchanger(exchangeHands);

        var tempHand = this.getHand();
        this.setHand(exchangee.getHand());
        exchangee.setHand(tempHand);
    }

    public Card showCard() {
        var random = new Random();
        var index = random.nextInt(this.getHand().getHand().size());
        return this.getHand().getHand().get(index);
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

    public Card getShowCard() {
        return showCard;
    }

    public void setShowCard(Card showCard) {
        this.showCard = showCard;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
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
}
