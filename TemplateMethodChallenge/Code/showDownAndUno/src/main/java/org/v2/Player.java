package org.v2;

public abstract class Player<T extends Card> {
    protected String name;
    protected Hand<T> hand;

    public Player() {
        this.hand = createHand();
    }

    public void nameHimself(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Hand<T> getHand() {
        return hand;
    }

    protected abstract Hand<T> createHand();
}


