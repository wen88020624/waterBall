package org.v2.showDown;

import org.v2.showDown.Card;
import org.v2.showDown.Deck;
import org.v2.showDown.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GameTemplate {
    protected Deck deck;
    protected List<Player> players;

    public GameTemplate() {
        this.players = new LinkedList<>();
        for (int i=1; i<=4; i++) {
            this.players.add(new Player());
        }
    }


    protected void start() {
        nameHimSelf();

        prepareGame();

        drawCard();

        playGame();
    }

    protected void nameHimSelf() {
        int index = 1;
        for (Player player : players) {
            player.nameHimself("P" + index);
            System.out.println("P" + index +"'s name: " + player.getName());
            index++;
        }
    }

    protected void prepareGame() {
        deck.shuffle();
    }

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

    protected abstract void playGame();

    protected abstract int getHandSize();
}
