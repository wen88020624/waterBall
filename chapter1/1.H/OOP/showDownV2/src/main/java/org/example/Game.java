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
        for (Player player : players) {
            player.nameHimself();
        }

        deck.shuffle();

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
                        return "P" + (index + 1) + " show card: " + cardDescription;
                    })
                    .collect(Collectors.joining("\n"));
            System.out.println(playerOfShowCard);

            int maxIndex = 0;
            for (int index=0; index<cards.size()-1; index++) {
                if (cards.get(maxIndex).isEmpty()) {
                    maxIndex = index;
                    continue;
                }
                if (cards.get(index).isPresent()) {
                    ShowDownResult result = cards.get(index).get().showDown(cards.get(maxIndex).get());

                    if (result==ShowDownResult.BIGGER) {
                        maxIndex = index;
                    }
                }
            }
            Player winner = players.get(maxIndex);
            winner.gainPoint();
        }

        Player winner = players.stream()
                .max(Comparator.comparing(Player::getPoint))
                .orElseThrow(() -> new RuntimeException("winner not found"));
        System.out.println("Winner is " + winner.getName() + ", Point: " + winner.getPoint());
    }
}
