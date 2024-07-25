package main.java.org.example;

import java.util.Optional;

public class TurnMove {
    private final Player player;
    private final Optional<ExchangeHands> exchangeHands;
    private final Card showCard;

    public TurnMove(Player player, Optional<ExchangeHands> exchangeHands, Card showCard) {
        this.player = player;
        this.exchangeHands = exchangeHands;
        this.showCard = showCard;
    }

    public Player getPlayer() {
        return player;
    }

    public Optional<ExchangeHands> getExchangeHands() {
        return exchangeHands;
    }

    public Card getShowCard() {
        return showCard;
    }
}
