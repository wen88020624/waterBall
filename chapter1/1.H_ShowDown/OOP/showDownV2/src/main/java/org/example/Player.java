package main.java.org.example;

import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public abstract class Player {
    protected int point = 0;
    protected ShowDown showDown;
    private String name;
    protected Hand hand = new Hand();
    protected ExchangeHands exchangeHands;

    public TurnMove takeTern() {
        TurnMove turnMove = new TurnMove(this, hasUsedExchangeHands() ?
                empty() : makeExchangeHandsDecision(), showCard());
        turnMove.getExchangeHands().ifPresent(this::setExchangeHands);
        getExchangeHands().ifPresent(ExchangeHands::countdown);
        return turnMove;
    }

    public abstract void nameHimself(int order);

    protected abstract Card showCard();

    protected abstract Optional<ExchangeHands> makeExchangeHandsDecision();

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

    public void setExchangeHands(ExchangeHands exchangeHands) {
        this.exchangeHands = exchangeHands;
    }

    public boolean hasUsedExchangeHands() {
        return exchangeHands != null;
    }

    public void addHandCard(Card card) {
        hand.addCard(card);
    }

    public Optional<ExchangeHands> getExchangeHands() {
        return ofNullable(exchangeHands);
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setShowDown(ShowDown showDown) {
        this.showDown = showDown;
    }
}
