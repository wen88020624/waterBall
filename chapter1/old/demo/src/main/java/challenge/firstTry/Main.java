package challenge.firstTry;

public class Main {
    public static void main(String[] args) {
        Player P1 = new RealPlayer();
        Player P2 = new RealPlayer();
        Player P3 = new RealPlayer();
        Player P4 = new RealPlayer();
        Game game = new Game(P1, P2, P3, P4);
        game.start();
    }
}
