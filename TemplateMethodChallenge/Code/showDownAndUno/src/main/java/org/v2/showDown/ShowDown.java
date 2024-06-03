package org.v2.showDown;

import org.v1.uno.DiscardPile;
import org.v2.*;
import org.v2.uno.Deck;

import java.util.*;

public class ShowDown extends GameTemplate {
    private final List<ShowDownPlayer> players = new ArrayList<>(4);
    private final PokerDeck deck = new PokerDeck();

    @Override
    protected Player createPlayer() {
        var random = new Random();
        if (random.nextBoolean()) {
            return new HumanShowDownPlayer();
        } else {
            return new AIShowDownPlayer();
        }
    }

    @Override
    protected Deck createDeck() {
        return new PokerDeck();
    }

    @Override
    protected DiscardPile createDiscardPile() {
        return new ShowDownDiscardPile();
    }

    @Override
    protected void playGame() {
        doThirteenRounds();

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
                .mapToInt(ShowDownPlayer::getPoint)
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
            var playersShowCardEachRound = new HashMap<ShowDownPlayer, PokerCard>();
            players.forEach(player -> {
                player.takeTern(players, playersShowCardEachRound);
            });
            printNameAndShowCard(playersShowCardEachRound);
            var winner = showDown(playersShowCardEachRound);
            winner.gainPoint();
        }
    }

    private ShowDownPlayer showDown(HashMap<ShowDownPlayer, PokerCard> playersShowCardEachRound) {
        ShowDownPlayer winner = null;
        PokerCard winnerCard = null;
        for (Map.Entry<ShowDownPlayer, PokerCard> entry : playersShowCardEachRound.entrySet()) {
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

    private void printNameAndShowCard(HashMap<ShowDownPlayer, PokerCard> playersShowCardEachRound) {
        playersShowCardEachRound.forEach((player, card) -> {
            System.out.println("Name: "+player.getName()+", Rank: "+card.getRank()+", Suit: "+card.getSuit());
        });
    }

}
