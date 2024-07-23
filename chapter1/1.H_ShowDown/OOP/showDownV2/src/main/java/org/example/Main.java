package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(
                List.of(
                        new HumanPlayer(),
                        new AIPlayer(),
                        new AIPlayer(),
                        new AIPlayer()
                )
        );
        game.start();
    }
}