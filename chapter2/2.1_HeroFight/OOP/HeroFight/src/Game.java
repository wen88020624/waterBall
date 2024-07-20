import java.util.List;

import static java.util.Collections.swap;

public class Game {
    private final List<Hero> heros;

    public Game(List<Hero> heros) {
        this.heros = heros;
    }

    public void start() {
        nextTern();

    }

    private void nextTern() {
        Hero attacker = heros.get(0);
        Hero defender = heros.get(1);
        attacker.attack(defender);
        swap(heros, 0, 1);
        if (defender.isDead()) {
            System.out.println("Game over, winner is: " + attacker.getName());
        } else {
            nextTern();
        }
    }
}
