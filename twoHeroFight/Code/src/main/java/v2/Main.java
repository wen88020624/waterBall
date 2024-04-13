package v2;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("阿文", new PowerBall());
        Hero hero2 = new Hero("阿筑", new Earth());
        Game game = new Game(hero1, hero2);
        game.start();
    }
}