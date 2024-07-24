package main.java.org.example;

import java.util.List;
import java.util.Optional;

import static ValidationUtils.requireNonNull;
import static java.util.Objects.requireNonNull;

public abstract class Player {
    private static int lastId = 0;
    private final int id;
    private String name;
    protected Hand hand;
    private int point = 0;
    protected boolean hasUsedExchangeHands = false;

    protected ExchangeHand exchangeHand;

    public Player() {
        id = ++lastId;
        this.hand = new Hand();
    }

    public abstract void nameHimself(int order);

    public Optional<Card> takeTern(List<Player> players) {
        if (exchangeHand != null) {
            exchangeHand.updateRemainTern();
            if (exchangeHand.getRemainTern() == 0) {
                exchangeHand.exchangeHandsBack();
            }
        }

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

        var exchangeHand = new ExchangeHand(this, exchangee);
        this.setExchangeHand(exchangeHand);

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

    public void setExchangeHand(ExchangeHand exchangeHand) {
        this.exchangeHand = exchangeHand;
    }
}
