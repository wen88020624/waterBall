package v2;

public class PowerBall implements AttackType {
    @Override
    public void attack(Hero hero1, Hero hero2) {
        hero2.damage(500);
    }
}
