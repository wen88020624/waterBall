package v2;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(asList(
                new Hero("Wen", new PowerBall()),
                new Hero("Cathy", new FireBall())
        ));
        game.start();
    }
}