package challenge.secondTry;

import java.util.List;

public class Player {
    private String name;
    private Integer point;

    private List<Card> hands;

    private Card showCard;
    private Boolean exchangeChance = true;
    private ExchangeHands exchangeHands;
    public void choose() {}

    public void nameHimSelf(String name) {
        this.name = name;
    }
    public void exchangeHands(Player player) {
        if (!this.exchangeChance) {
            throw new IllegalStateException("You can't use exchangeHands twice!");
        }
        ExchangeHands exchangeHands = new ExchangeHands(this, player);
        this.exchangeHands = exchangeHands;
        player.exchangeHands = exchangeHands;
        List<Card> tempHands = this.hands;
        this.hands = player.getHands();
        player.setHands(tempHands);
        this.setExchangeChance(false);
    }

    public void show(Card card) {
        this.showCard = card;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public Integer getPoint() {
        return point;
    }

    public List<Card> getHands() {
        return hands;
    }

    public Card getShowCard() {
        return showCard;
    }

    public void setExchangeChance(Boolean exchangeChance) {
        this.exchangeChance = exchangeChance;
    }

    public void setHands(List<Card> hands) {
        this.hands = hands;
    }

    public void setExchangeHands(ExchangeHands exchangeHands) {
        this.exchangeHands = exchangeHands;
    }

    public void setShowCard(Card showCard) {
        this.showCard = showCard;
    }
}
