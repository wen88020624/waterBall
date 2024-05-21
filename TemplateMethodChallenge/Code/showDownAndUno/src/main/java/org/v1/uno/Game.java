package org.v1.uno;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Game {
    private Deck deck;
    private List<Player> players;
    private DiscardPile discardPile;

    public Game() {
        this.discardPile = new DiscardPile();
        this.deck = new Deck(discardPile);
        this.players = new LinkedList<>();
        for (int i=1; i<=4; i++) {
            this.players.add(new Player());
        }
    }

    public void start() {

        int index = 1;
        for (Player player : players) {
            player.nameHimself("P" + index);
            System.out.println("P" + index +"'s name: " + player.getName());
            index++;
        }

        deck.shuffle();

        for (Player player : players) {
            while(player.getHand().size() <= 5)
                player.getHand().add(deck.drawCard());

            String handDes = player.getHand().getCards().stream()
                            .map(Card :: toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " finished drawCard: " + handDes);
        }

        discardPile.addTop(Optional.of(deck.drawCard()));

        Player winner = null;
        boolean gameWon = false;
        while(!gameWon) {
            for (Player player : players) {
                playerTurn(player);
                if (isPlayerWon(player)) {
                    winner = player;
                    gameWon = true;
                    break;
                }
            }
        }

        System.out.println("Winner is: " + winner.getName());
    }

    private void playerTurn(Player player) {
        Card topCard = discardPile.getTopCard();
        discardPile.addTop(player.showCard(topCard, this.deck));

        var discardPileDesc = discardPile.getCards().stream()
                        .map(Card :: toString)
                                .collect(Collectors.joining(", "));
        System.out.println("discardPile: " + discardPileDesc);
    }

    private boolean isPlayerWon(Player player) {
        return player.getHand().size() == 0;
    }
}
