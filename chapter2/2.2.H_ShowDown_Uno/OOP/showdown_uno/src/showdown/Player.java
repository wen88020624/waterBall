package showdown;

public abstract class Player {
    private String name;

    private int point = 0;
    private Hand hand = new Hand();
    private Showdown showdown;

    public abstract void nameSelf(int order);

    public TurnMove takeTurn() {
        System.out.printf("It's %s turn.", this.getName());
        Card card = showCard();
        return new TurnMove(this, card);
    };

    protected abstract Card showCard();

    public void gainPoint() {
        this.point++;
    }

    public void addHandCard(Card card) {
        this.hand.addHand(card);
    }

    public void setShowdown(Showdown showdown) {
        this.showdown = showdown;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public Hand getHand() {
        return hand;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
