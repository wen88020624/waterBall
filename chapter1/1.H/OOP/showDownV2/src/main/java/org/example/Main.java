package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(
                List.of(
                        new AIPlayer(),
                        new HumanPlayer(),
                        new HumanPlayer(),
                        new AIPlayer()
                )
        );

        game.start();
    }
}