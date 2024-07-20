package v2;

public class PowerBall implements AttackType{
    @Override
    public void attack(Hero attacker, Hero defender) {
        attacker.damage(defender, 500);
    }
}
