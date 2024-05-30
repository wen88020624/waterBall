package org.v2.showDown;

import java.util.HashMap;
import java.util.Map;

public class showDown extends GameTemplate{
    private final Deck deck = new Deck();

    public showDown() {
        super();
    }

    @Override
    protected void playGame() {
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

        calculatePoints();

        printWinner();
    }

    @Override
    protected int getHandSize() {
        return 13;
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
}
