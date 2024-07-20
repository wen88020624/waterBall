package v2;

public class Earth implements AttackType {
    @Override
    public void attack(Hero attacker, Hero defender) {
        for (int i=0; i<=10; i++) {
            attacker.damage(defender, 20);
        }
    }
}
