package challenge.secondTry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<Player> players = new ArrayList<>(4);;
    private final Deck deck = new Deck();

    public Game(Player P1, Player P2, Player P3, Player P4) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player 1, please enter your name: ");
        String name1 = scanner.nextLine();
        P1.setName(name1);

        System.out.print("Player 2, please enter your name: ");
        String name2 = scanner.nextLine();
        P2.setName(name2);

        System.out.print("Player 3, please enter your name: ");
        String name3 = scanner.nextLine();
        P3.setName(name3);

        System.out.print("Player 4, please enter your name: ");
        String name4 = scanner.nextLine();
        P4.setName(name4);

        this.deck.shuffle();
    }

    public void cardDrawingPhase() {
        for (Player player : players) {
            if (isAllPlayersFinishDrawingCard(players)) {
                break;
            }
            deck.drawCard(player);
        }
    }

    private boolean isAllPlayersFinishDrawingCard(List<Player> players) {
        for(Player player : players) {
            if (player.getHands().size() != 13) {
                return false;
            }
        }
        return true;
    }

    public Player findMaxiMum(List<Player> players) {
        if (players == null || players.isEmpty()) {
            return null;
        }

        Player maxPlayer = players.get(0);
        for (Player player : players) {
            if (player.getShowCard().compareTo(maxPlayer.getShowCard()) > 0) {
                maxPlayer = player;
            }
        }
        return maxPlayer;
    }

    public void gainPoint(Player player) {
        player.setPoint(player.getPoint() + 1);
    }

    public String showWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getPoint() > winner.getPoint()) {
                winner = player;
            }
        }
        return winner.getName();
    }
}
