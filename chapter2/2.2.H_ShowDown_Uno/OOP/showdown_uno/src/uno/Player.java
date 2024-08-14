package uno;

import java.util.Optional;

public abstract class Player {
    private String name;
    private Hand hand = new Hand();
    private Uno uno;

    public abstract void nameSelf(int order);

    public void addHandCard(Card card) {
        hand.add(card);
    }

    public Hand getHand() {
        return this.hand;
    }

    public Optional<TurnMove> takeTurn() {
        Card topCard = getUno().getCardStack().peek();
        System.out.printf("It's %s turn, the top card is: %s\n", this.getName(), topCard.toString());
        boolean hasSelections = getHand().getCards().stream()
                .anyMatch(c -> c.equalNumber(topCard) || c.equalColor(topCard));

        if (hasSelections) {
            Card card = showCard();
            return Optional.of(new TurnMove(this, card));
        } else {
            this.addHandCard(uno.getDeck().draw());
            return Optional.empty();
        }
    }

    protected abstract Card showCard();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUno(Uno uno) {
        this.uno = uno;
    }

    public Uno getUno() {
        return uno;
    }
}
