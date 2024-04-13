package v2;

public class FireBall implements AttackType{
    @Override
    public void attack(Hero hero1, Hero hero2) {
        for (int i=0; i<3; i++) {
            hero2.damage(50);
        }
    }
}
