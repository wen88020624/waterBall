package showdown;

public abstract class Player {
    private String name;
    private int point = 0;
    private Hand hand = new Hand();
    private Showdown showdown;
    public abstract void nameSelf(int order);

    public abstract TurnMove takeTurn();

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
}
