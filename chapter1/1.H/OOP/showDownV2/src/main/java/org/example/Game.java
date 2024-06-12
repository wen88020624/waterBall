package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private List<Player> players;
    private Deck deck;

    public Game(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
    }

    public void start() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("P" + (i+1) + " Please name yourself: ");
            players.get(i).nameHimself();
        }

        deck.shuffle();

        for (int i = 0; i<players.size(); i++) {
            while (players.get(i).getHand().size() < 13) {
                players.get(i).getHand().add(deck.drawCard());
            }
            System.out.println("P" + (i+1) + ", name: " + players.get(i).getName() +
                    ", finished draw card, hand size: " + players.get(i).getHand().size());
        }

        for (int tern=1; tern<=13; tern++) {
            List<Optional<Card>> cards = new ArrayList<>();
            for (Player player : players) {
                cards.add(player.takeTern(players));
            }

            String playerOfShowCard = IntStream.range(0, cards.size())
                    .mapToObj(index -> {
                        String cardDescription = cards.get(index)
                                .map(Card::toString)
                                .orElse("No show card");
                        return "P" + (index + 1) + ", " + players.get(index).getName() + " show card: " + cardDescription;
                    })
                    .collect(Collectors.joining("\n"));
            System.out.println(playerOfShowCard);

            int maxIndex = -1;
            for (int index = 0; index < cards.size(); index++) {
                if (cards.get(index).isEmpty()) {
                    continue;
                }
                if (maxIndex == -1 || cards.get(index).get().showDown(cards.get(maxIndex).get()) == ShowDownResult.BIGGER) {
                    maxIndex = index;
                }
            }

            Player winner = players.get(maxIndex);
            winner.gainPoint();
        }

        Player finalWinner = players.stream()
                .max(Comparator.comparing(Player::getPoint))
                .orElseThrow(() -> new RuntimeException("No winner!"));
        System.out.println("Final winner: " + finalWinner.getName() + ", Point: " + finalWinner.getPoint());
    }
}
