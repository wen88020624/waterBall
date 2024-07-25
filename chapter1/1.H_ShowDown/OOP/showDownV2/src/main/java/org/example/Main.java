package main.java.org.example;

import java.util.List;

import static main.java.org.example.Deck.standard52Cards;

public class Main {
    public static void main(String[] args) {
        ShowDown showDown = new ShowDown(
                standard52Cards(),
                List.of(
                        new HumanPlayer(),
                        new AI(),
                        new AI(),
                        new AI()
                )
        );
        showDown.start();
    }
}