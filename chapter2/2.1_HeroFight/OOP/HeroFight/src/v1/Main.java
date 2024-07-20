package v1;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(asList(
                new Hero("Wen", "waterBall"),
                new Hero("Cathy", "fireBall")
        ));
        game.start();
    }
}