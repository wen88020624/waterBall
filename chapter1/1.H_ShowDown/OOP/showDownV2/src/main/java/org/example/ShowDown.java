package main.java.org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShowDown {
    private static final int NUM_OF_ROUNDS = 13;
    private final Deck deck;
    private final List<Player> players;
    private final List<TurnMove> turnMoves = new ArrayList<>();

    public ShowDown(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;

    }

    public void start() {
        nameThemselves();
        deck.shuffle();
        drawHands();

        for (int round=1; round<=13; round++) {
            System.out.println("round: " + round);

            List<Optional<Card>> cards = new ArrayList<>();
            for (Player player : players) {
                cards.add(player.takeTern(players));
            }

            String playerOfShowCard = IntStream.range(0, cards.size())
                    .mapToObj(index -> {
                        String cardDescription = cards.get(index)
                                .map(Card::toString)
                                .orElse("No show card");
                        return "P" + (index + 1) + ", " + players.get(index).getName() +
                                " show card: " + cardDescription +
                                " , hand: " + players.get(index).getHand().printHand() +
                                " , handSize: " + players.get(index).getHand().size();
                    })
                    .collect(Collectors.joining("\n"));
            System.out.println(playerOfShowCard);

            int maxIndex = -1;
            for (int index = 0; index < cards.size(); index++) {
                if (cards.get(index).isEmpty()) {
                    continue;
                }
                if (maxIndex == -1 || cards.get(index).get().compareTo(cards.get(maxIndex).get())) {
                    maxIndex = index;
                }
            }

            Player winner = players.get(maxIndex);
            System.out.println("winner: " + winner.getName() + " , show card: " + cards.get(maxIndex).get().toString());
            winner.gainPoint();
        }

        Player finalWinner = players.stream()
                .max(Comparator.comparing(Player::getPoint))
                .orElseThrow(() -> new RuntimeException("No winner!"));
        System.out.println("Final winner: " + finalWinner.getName() + ", Point: " + finalWinner.getPoint());
    }

    private void drawHands() {
        int deckSize = deck.size();
        for (int i = 0; i < deckSize; i++) {
            Card card = deck.draw();
            players.get(i % players.size()).addHandCard(card);
        }
    }

    private void nameThemselves() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameHimself(i + 1);
        }
    }
}
