package uno;

import showdown.HumanPlayer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = Deck.standard40UnoCards();
        List<Player> players = new ArrayList<>(
                new HumanPlayer(),
                new AI(),
                new AI(),
                new AI()
        );

        Uno uno = new Uno(players, deck);
        uno.start();
    }
}
