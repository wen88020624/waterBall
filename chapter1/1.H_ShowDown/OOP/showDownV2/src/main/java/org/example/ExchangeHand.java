package main.java.org.example;

import java.util.List;

public class ExchangeHand {
    private final Player exchanger;
    private final Player exchangee;
    private int remainTern = 3;

    public ExchangeHand(Player exchanger, Player exchangee) {
        this.exchanger = exchanger;
        this.exchangee = exchangee;
    }

    public void exchangeHandsBack() {
        System.out.println("Before exchange back." + "\n" +
                "Exchanger: " + exchanger.getName() + " , Exchanger.hand: " + exchanger.getHand().printHand() + "\n" +
                "Exchangee: " + exchangee.getName() + " , Exchangee.hand: " + exchangee.getHand().printHand());
        List<Card> temp = exchanger.getHand().getCards();
        exchanger.getHand().setCards(exchangee.getHand().getCards());
        exchangee.getHand().setCards(temp);

        exchanger.setExchangeHand(null);

        System.out.println("Exchange back." + "\n" +
                "Exchanger: " + exchanger.getName() + " , Exchanger.hand: " + exchanger.getHand().printHand() + "\n" +
                "Exchangee: " + exchangee.getName() + " , Exchangee.hand: " + exchangee.getHand().printHand());
    }

    public void updateRemainTern() {
        remainTern--;
        System.out.println("exchanger: " + exchanger.getName() + " , exchangee: " + exchangee.getName() + " , remainTern: " + remainTern);
    }

    public int getRemainTern() {
        return remainTern;
    }
}
