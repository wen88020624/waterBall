package org.example;

import java.util.ArrayList;
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
        for (Player player : players) {
            player.nameHimself();
        }

        deck.shuffle();

        for (int i=1; i<=13; i++) {
            List<Optional<Card>> cards = new ArrayList<>();
            for (Player player : players) {
                cards.add(player.takeTern(players));
            }

            String playerOfShowCard = IntStream.range(0, cards.size())
                    .mapToObj(index -> {
                        String cardDescription = cards.get(index)
                                .map(Card::toString)
                                .orElse("No show card");
                        return "P" + (index + 1) + " show card: " + cardDescription;
                    })
                    .collect(Collectors.joining("\n"));
            System.out.println(playerOfShowCard);

            Player winner = IntStream.range(0, cards.size())
                    .mapToObj(index -> {
                        if (cards.get(index).isPresent()) {

                        }
                    })

        }
    }
}
