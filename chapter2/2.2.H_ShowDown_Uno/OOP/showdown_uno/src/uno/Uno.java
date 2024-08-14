package uno;

import java.util.List;
import java.util.Optional;

public class Uno {
    private final List<Player> players;
    private final Deck deck;
    private Deck cardStack = new Deck();

    public Uno(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        players.forEach(player -> player.setUno(this));
    }

    public void start() {
        nameThemself();
        deck.shuffle();
        drawHands();
        cardStack.push(deck.draw());
        playerRounds();
    }

    private void playerRounds() {
        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                Optional<TurnMove> turnMove = player.takeTurn();
                turnMove.ifPresent(move -> cardStack.push(move.getShowCard()));

                if (player.getHand().size() == 0) {
                    gameOver = true;
                    System.out.printf("Winner is %s", player.getName());
                }
            }
        }
    }

    private void drawHands() {
        for (Player player : players) {
            while (player.getHand().size() < 5) {
                Card card = deck.draw();
                player.addHandCard(card);
            }
        }
    }

    private void nameThemself() {
        for (int i=0; i< players.size(); i++) {
            players.get(i).nameSelf(i);
        }
    }

    public Deck getCardStack() {
        return cardStack;
    }

    public Deck getDeck() {
        return deck;
    }
}
