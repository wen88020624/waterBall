package v2;

public class WaterBall implements AttackType {
    @Override
    public void attack(Hero attacker, Hero defender) {
        attacker.damage(defender, (int) (attacker.getHp() * 0.5));
    }
}
