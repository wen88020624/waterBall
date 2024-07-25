package main.java.org.example;

import java.util.List;
import java.util.Optional;

import static ValidationUtils.requireNonNull;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;

public abstract class Player {
    protected int point = 0;
    protected ShowDown showDown;
    private String name;
    protected Hand hand = new Hand();

    protected ExchangeHands exchangeHands;

    public Optional<Card> takeTern(List<Player> players) {
        TurnMove turnMove = new TurnMove(this, hasUsedExchangeHands() ?
                empty() : makeExchangeHandsDecision(), showCard());
        turnMove.getExchangeHands().ifPresent(this::setExchangeHands);
        getExchangeHands().ifPresend(this::)

        boolean isUse = makeExchangeHandsDecision();

        if (isUse) {
            exchangeHands(players);
        }

        return showCard();
    }

    public abstract void nameHimself(int order);

    protected abstract Card showCard();

    private void exchangeHands(List<Player> players) {
        hasUsedExchangeHands = true;
        Player exchangee = chooseExchangee(players);
        System.out.println("Before exchange." + "\n" +
                "Exchanger: " + getName() + " , Exchanger.hand: " + getHand().printHand() + "\n" +
                "Exchangee: " + exchangee.getName() + " , Exchangee.hand: " + exchangee.getHand().printHand());

        var exchangeHand = new ExchangeHands(this, exchangee);
        this.setExchangeHands(exchangeHand);

        //交換手牌
        Hand temp = this.hand;
        this.hand = exchangee.hand;
        exchangee.hand = temp;
        System.out.println("After exchange." + "\n" +
                "Exchanger: " + getName() + " , Exchanger.hand: " + getHand().printHand() + "\n" +
                "Exchangee: " + exchangee.getName() + " , Exchangee.hand: " + exchangee.getHand().printHand());
    }

    protected abstract Optional<ExchangeHands> makeExchangeHandsDecision();

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

    public void setExchangeHands(ExchangeHands exchangeHands) {
        this.exchangeHands = exchangeHands;
    }

    public boolean hasUsedExchangeHands() {
        return exchangeHands != null;
    }

    public void addHandCard(Card card) {
        hand.addCard(card);
    }

    public ExchangeHands getExchangeHands() {
        return exchangeHands;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
