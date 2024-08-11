package uno;

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

    public TurnMove takeTurn() {
        System.out.printf("It's %s turn.", this.getName());
        Card card = showCard();
        return new TurnMove(this, card);
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
