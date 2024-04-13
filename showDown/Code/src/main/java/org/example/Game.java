package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private final List<Player> players = new ArrayList<>(4);
    private final Deck deck = new Deck();

    public void start() {
        nameHimSelfEachPlayers();
        deck.shuffle();
        drawCardEachPlayers();
        doThirteenRounds();
        calculatePoints();
        printWinner();
    }

    private void calculatePoints() {
        System.out.println("Calculating points");
        players.forEach(player -> {
            System.out.println("Name: "+player.getName()+", Point: "+player.getPoint());
        });
    }

    private void printWinner() {
        int maxPoint = players.stream()
                .mapToInt(Player::getPoint)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));

        var winners = players.stream()
                .filter(player -> player.getPoint() == maxPoint)
                .toList();

        winners.forEach(player -> System.out.print("Last Winner is: " + player.getName() + ", point: " + player.getPoint()+"\n"));
    }

    private void doThirteenRounds() {
        for (int round=1; round<=13; round++) {
            System.out.println("round: "+round);
            var playersShowCardEachRound = new HashMap<Player, Card>();
            players.forEach(player -> {
                player.takeTern(players, playersShowCardEachRound);
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
        System.out.println("winner: "+winner.getName()+", rank: "+ winnerCard.getRank()+", suit: "+ winnerCard.getSuit());
        return winner;
    }

    private void printNameAndShowCard(HashMap<Player, Card> playersShowCardEachRound) {
        playersShowCardEachRound.forEach((player, card) -> {
            System.out.println("Name: "+player.getName()+", Rank: "+card.getRank()+", Suit: "+card.getSuit());
        });
    }

    private void drawCardEachPlayers() {
        players.forEach(player -> {
            System.out.println("drawCardName: "+player.getName());
            player.setHand(new Hand());
            while (player.getHand().getCards().size() < 13)
                player.getHand().addToHand(deck.drawCard());
            System.out.println("name: "+player.getName()+", hand.size: "+player.getHand().getCards().size());
        });
    }

    private void nameHimSelfEachPlayers() {
        for (int i=1; i<=4; i++) {
            var player = new Player();
            player.nameHimSelf("P" + i);
            System.out.println("players: "+players+", playerName: "+player.getName());
            players.add(player);
        }
    }
}
