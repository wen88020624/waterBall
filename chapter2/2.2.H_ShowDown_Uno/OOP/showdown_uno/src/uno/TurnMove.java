package uno;

public class TurnMove {
    private final Player player;
    private final Card showCard;

    public TurnMove(Player player, Card showCard) {
        this.player = player;
        this.showCard = showCard;
    }
}
