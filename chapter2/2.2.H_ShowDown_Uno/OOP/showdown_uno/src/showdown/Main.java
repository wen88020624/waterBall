package showdown;

import java.util.List;

import static java.util.Arrays.asList;
import static showdown.Deck.standard52Cards;

public class Main {
    public static void main(String[] args) {
        List<Player> players = asList(new HumanPlayer(), new AI(), new AI(), new AI());
        Showdown showdown = new Showdown(players, standard52Cards());
        showdown.start();
    }
}