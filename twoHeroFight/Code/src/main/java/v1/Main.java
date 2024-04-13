package v1;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("阿文", "WaterBall");
        Hero hero2 = new Hero("阿筑", "FireBall");
        Game game = new Game(hero1, hero2);
        game.start();
    }
}