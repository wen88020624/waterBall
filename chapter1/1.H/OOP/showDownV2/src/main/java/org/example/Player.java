package org.example;

import java.util.*;

import static org.example.ValidationUtils.lengthShouldBe;
import static org.example.ValidationUtils.requireNonNull;

public abstract class Player {
    protected int playerNumber;
    protected Set<Integer> chosenPlayers = new HashSet<>();
    private String name;
    protected Hand hand;
    private int point = 0;
    private boolean hasUsedExchangeHands = false;
    protected List<ExchangeHand> exchangeHands;

    public Player() {
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

    private boolean makeDecision() {
        if (hasUsedExchangeHands) {
            return false;
        }
        //隨機決定是否要交換手牌
        var random = new Random();
        return random.nextBoolean();
    }

    private void exchangeHands(List<Player> players) {
        hasUsedExchangeHands = true;
        Player exchangee = chooseExchangee(players);

        //交換手牌
        Hand temp = this.hand;
        this.hand = exchangee.hand;
        exchangee.hand = temp;
    }

    protected abstract Player chooseExchangee(List<Player> players);

    private void gainPoint() {
        point++;
    }

    public void setName(String name) {
        this.name = requireNonNull(name);
    }

    protected abstract void choosePlayer();

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = lengthShouldBe(playerNumber, 1, 4);
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
}
