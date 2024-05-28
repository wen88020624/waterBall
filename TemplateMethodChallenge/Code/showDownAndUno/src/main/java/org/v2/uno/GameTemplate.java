package org.v2.uno;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GameTemplate {
    protected Deck deck;
    protected List<Player> players;


    protected void start() {
        nameHimSelf();

        prepareGame();

        drawCard();

        gameStart();
    }

    protected void prepareGame() {
        deck.shuffle();
    }

    protected void gameStart() {
        Player winner = null;
        boolean gameFinish = false;
        while(!gameFinish) {
            for (Player player : players) {
                takeTurn(player);
            }

            printShowCard();

            judge();

            if (isFinishGame()) {
                winner = findWinner();
                gameFinish = true;
                break;
            }
        }
    }

    protected abstract Player findWinner();

    private void printShowCard() {
        for (Player player : players) {
            String handDes = player.getHand().getCards().stream()
                    .map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " finished drawCard: " + handDes);
        }
    }

    protected abstract void judge();

    protected abstract boolean isFinishGame();

    protected abstract void takeTurn(Player player);

    protected void drawCard() {
        for (Player player : players) {
            while (player.getHand().size() < getHandSize()) {
                player.getHand().add(deck.drawCard());
            }

            String handDes = player.getHand().getCards().stream()
                    .map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " finished drawCard: " + handDes);
        }
    }

    protected abstract int getHandSize();

    protected void nameHimSelf() {
        int index = 1;
        for (Player player : players) {
            player.nameHimself("P" + index);
            System.out.println("P" + index +"'s name: " + player.getName());
            index++;
        }
    }
}
