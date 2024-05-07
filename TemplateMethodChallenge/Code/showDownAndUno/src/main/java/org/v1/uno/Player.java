package org.v1.uno;

public class Player {

    private String name;
    private Hand hand;

    public void nameHimself(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

}
