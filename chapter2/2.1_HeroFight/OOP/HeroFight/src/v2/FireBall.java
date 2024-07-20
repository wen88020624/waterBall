package v2;

public class FireBall implements AttackType {
    @Override
    public void attack(Hero attacker, Hero defender) {
        for (int i=0; i<=3; i++) {
            attacker.damage(defender, 50);
        }
    }
}
