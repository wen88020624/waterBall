package org.example;

import java.util.List;
import java.util.Optional;

import static org.example.ValidationUtils.requireNonNull;

public abstract class Player {
    protected static int playerNumber;
    protected final int id;
    private String name;
    protected Hand hand;
    private int point = 0;
    protected boolean hasUsedExchangeHands = false;
    protected List<ExchangeHand> exchangeHands;
    public Player() {
        id = ++playerNumber;
        this.hand = new Hand();
    }

    public abstract void nameHimself();
    public Optional<Card> takeTern(List<Player> players) {
        boolean isUse = makeDecision();

        if (isUse) {
            exchangeHands(players);
        }

        return showCard();
    }

    protected abstract Optional<Card> showCard();

    private void exchangeHands(List<Player> players) {
        hasUsedExchangeHands = true;
        Player exchangee = chooseExchangee(players);
        System.out.println("Before exchange." + "\n" +
                "Exchanger: " + getName() + " , Exchanger.hand: " + getHand().printHand() + "\n" +
                "Exchangee: " + exchangee.getName() + " , Exchangee.hand: " + exchangee.getHand().printHand());
        //交換手牌
        Hand temp = this.hand;
        this.hand = exchangee.hand;
        exchangee.hand = temp;
        System.out.println("After exchange." + "\n" +
                "Exchanger: " + getName() + " , Exchanger.hand: " + getHand().printHand() + "\n" +
                "Exchangee: " + exchangee.getName() + " , Exchangee.hand: " + exchangee.getHand().printHand());
    }

    protected abstract boolean makeDecision();

    protected abstract Player chooseExchangee(List<Player> players);

    public void gainPoint() {
        point++;
    }

    public void setName(String name) {
        this.name = requireNonNull(name);
    }

    public List<ExchangeHand> getExchangeHands() {
        return exchangeHands;
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return point;
    }

    public int getId() {
        return id;
    }
}
