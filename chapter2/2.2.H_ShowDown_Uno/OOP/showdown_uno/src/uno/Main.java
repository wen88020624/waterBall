package uno;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Deck deck = Deck.standard40UnoCards();
        List<Player> players = asList(new HumanPlayer(), new AI(), new AI(), new AI());

        Uno uno = new Uno(players, deck);
        uno.start();
    }
}
