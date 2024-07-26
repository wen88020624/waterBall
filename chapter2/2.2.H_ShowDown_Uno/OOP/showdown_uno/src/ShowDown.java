import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.max;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static main.java.org.example.Utils.printf;
import static main.java.org.example.Utils.println;

public class ShowDown {
    private static final int NUM_OF_ROUNDS = 13;
    private final Deck deck;
    private final List<Player> players;
    private final List<TurnMove> turnMoves = new ArrayList<>();

    public ShowDown(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
        players.forEach(p -> p.setShowDown(this));
    }

    public void start() {
        nameThemselves();
        deck.shuffle();
        drawHands();
        playRounds();
        gameOver();
    }

    private void gameOver() {
        Player winner = max(players, comparingInt(Player::getPoint));
        printf("The winner is %s.", winner.getName());
    }

    private void takeTurn(Player player) {
        printf("It's %s's turn.\n", player.getName());
        TurnMove turnMove = player.takeTern();
        turnMoves.add(turnMove);
    }

    private void playRounds() {
        for (int i = 0; i < NUM_OF_ROUNDS; i++) {
            players.forEach(this::takeTurn);
            showdown();
            turnMoves.clear();
        }
    }

    private void showdown() {
        printShowCards();
        TurnMove winnerTurnMove = max(turnMoves, comparing(TurnMove::getShowCard));
        Player winner = winnerTurnMove.getPlayer();
        winner.gainPoint();
        printf("%s wins this round.\n", winner.getName());
    }

    private void printShowCards() {
        printf("Show cards: ");
        println(turnMoves.stream()
                .map(TurnMove::getShowCard)
                .map(Objects::toString)
                .collect(joining(" ")));

    }

    private void drawHands() {
        int deckSize = deck.size();
        for (int i = 0; i < deckSize; i++) {
            Card card = deck.draw();
            players.get(i % players.size()).addHandCard(card);
        }
    }

    private void nameThemselves() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameHimself(i + 1);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

}
