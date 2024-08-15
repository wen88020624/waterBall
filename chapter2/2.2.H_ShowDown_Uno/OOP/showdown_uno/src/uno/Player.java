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
        System.out.printf("It's %s turn, the top card is: %s, handSize: %s\n", this.getName(), topCard.toString(), getHand().size());
        boolean hasSelections = getHand().getCards().stream()
                .anyMatch(c -> c.equalNumber(topCard) || c.equalColor(topCard));

        if (hasSelections) {
            Card card = showCard();
            return Optional.of(new TurnMove(this, card));

        } else {
            if (isDeckEmpty()) {
                getCardFromCardStack();
            }
            Card card = uno.getDeck().draw();
            this.addHandCard(card);
            return Optional.empty();
        }
    }

    private void getCardFromCardStack() {
        Card top = getUno().getCardStack().draw();
        while (getUno().getCardStack().size() >= 0) {
            getUno().getDeck().push(getUno().getCardStack().draw());
        }
        getUno().getDeck().shuffle();
        uno.getCardStack().push(top);
    }

    private boolean isDeckEmpty() {
        return uno.getDeck().size() == 0;
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
