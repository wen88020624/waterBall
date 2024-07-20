import java.util.List;

public class Game {
    private final List<Hero> heros;

    public Game(List<Hero> heros) {
        this.heros = heros;
    }

    public void start() {
        int turn = 0;
        boolean gameOver = false;
        Hero winner = null;
        Hero hero1 = heros.get(0);
        Hero hero2 = heros.get(1);

        while (!gameOver) {
            System.out.println("Turn: " + turn);

            if (turn % 2 == 0) {
                hero1.attack(hero2);
                if (hero2.isDead()) {
                    gameOver = true;
                    winner = hero1;
                }
            } else {
                hero2.attack(hero1);
                if (hero1.isDead()) {
                    gameOver = true;
                    winner = hero2;
                }
            }

            turn++;
        }

        System.out.println("Game over, winner is: " + winner.getName());
    }
}
