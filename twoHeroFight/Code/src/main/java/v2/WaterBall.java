package v2;

public class WaterBall implements AttackType {

    @Override
    public void attack(Hero hero1, Hero hero2) {
        hero2.damage((int) (hero1.getHp() * 0.5));
    }
}
