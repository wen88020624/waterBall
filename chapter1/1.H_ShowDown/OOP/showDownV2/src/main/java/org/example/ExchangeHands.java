package main.java.org.example;

import static main.java.org.example.Utils.printf;

public class ExchangeHands {
    private final Player exchanger;
    private final Player exchangee;
    private int countDown = 3;

    public ExchangeHands(Player exchanger, Player exchangee) {
        this.exchanger = exchanger;
        this.exchangee = exchangee;
        exchange();
    }

    public void exchange() {
        Hand hand = exchanger.getHand();
        exchanger.setHand(exchangee.getHand());
        exchangee.setHand(hand);
        printf("You have exchanged your hand with the player %s.\n", exchanger.getName());
    }

    public void countdown() {
        countDown--;
        if (countDown == 0) {
            exchange(); // exchange back when count down 0
        }
    }
}
