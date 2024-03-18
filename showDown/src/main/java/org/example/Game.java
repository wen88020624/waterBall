package org.example;

import java.util.*;

public class Game {
    private final List<Player> players = new ArrayList<>(4);
    private final Deck deck = new Deck();

    private void start() {
        nameHimSelfEachPlayers();
        deck.shuffle();
        drawCardEachPlayers();
        doThirteenRounds();
        printWinner(players);
    }

    private void printWinner(List<Player> players) {
        Optional<Player> winner = players.stream()
                .max(Comparator.comparing(Player::getPoint));
        winner.ifPresent(player -> System.out.print("Winner is: " + player.getName() + ", point: " + player.getPoint()));
    }

    private void doThirteenRounds() {
        for (int round=0; round<13; round++) {
            var playersShowCardEachRound = new HashMap<Player, Card>();
            players.forEach(player -> {
                player.takeTern(player, playersShowCardEachRound);
            });
            printNameAndShowCard(playersShowCardEachRound);
            var winner = showDown(playersShowCardEachRound);
            winner.gainPoint();
        }
    }

    private Player showDown(HashMap<Player, Card> playersShowCardEachRound) {
        Player winner = null;
        Card winnerCard = null;
        for (Map.Entry<Player, Card> entry : playersShowCardEachRound.entrySet()) {
            var player = entry.getKey();
            var card = entry.getValue();
            if (winner == null || winnerCard.showDown(card) == ShowDownResult.SMALLER) {
                winner = player;
                winnerCard = card;
            }
        }
        return winner;
    }

    private void printNameAndShowCard(HashMap<Player, Card> playersShowCardEachRound) {
        playersShowCardEachRound.forEach((player, card) -> {
            System.out.println("Name: "+player.getName()+"Rank: "+card.getRank()+"Suit: "+card.getSuit());
        });
    }

    private void drawCardEachPlayers() {
        players.forEach(player -> {
            while (player.getHand().size() < 13)
                player.getHand().addToHand(deck.drawCard());
        });
    }

    private void nameHimSelfEachPlayers() {
        for (int i=0; i<players.size(); i++) {
            players.get(i).nameHimSelf("P" + i);
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
