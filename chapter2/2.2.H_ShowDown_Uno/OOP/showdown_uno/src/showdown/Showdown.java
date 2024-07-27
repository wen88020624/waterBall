package showdown;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class Showdown {
    public static final int TOTAL_ROUNDS = 13;
    private final Deck deck;
    private final List<Player> players;
    private List<TurnMove> turnMoves = new ArrayList<>();

    public Showdown(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        players.forEach(p -> p.setShowdown(this));
    }

    public void start() {
        nameThemself();
        deck.shuffle();
        drawHands();
        playRounds();
        gameOver();
    }

    private void gameOver() {
        Player winner = max(players, Comparator.comparingInt(Player::getPoint));
        System.out.printf("The winner is %s.\n", winner.getName());
    }

    private void nameThemself() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameSelf(i+1);
        }
    }

    private void drawHands() {
        int deckSize = deck.size();
        for (int i = 0; i < deckSize; i++) {
            Card card = deck.draw();
            players.get(i % players.size()).addHandCard(card);
        }
    }

    private void playRounds() {
        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            players.forEach(this::takeTurn);
            printShowCards();
            showdown();
        }
    }

    private void showdown() {
        TurnMove winnerTurnMove = max(turnMoves, Comparator.comparing(TurnMove::getShowCard));
        Player winner = winnerTurnMove.getPlayer();
        winner.gainPoint();
        System.out.printf("%s wins this round.\n", winner.getName());
    }

    private void takeTurn(Player player) {
        System.out.printf("It's %s's turn.\n", player.getName());
        TurnMove turnMove = player.takeTurn();
        turnMoves.add(turnMove);
    }

    private void printShowCards() {
        System.out.print("Show cards: ");
        System.out.println(turnMoves.stream()
                .map(TurnMove::getShowCard)
                .map(Card::toString)
                .collect(Collectors.joining(" ")));
    }
}
