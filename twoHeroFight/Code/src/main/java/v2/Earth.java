package v2;

public class Earth implements AttackType {
    @Override
    public void attack(Hero hero1, Hero hero2) {
        for (int i=0; i<10; i++) {
            hero2.damage(20);
        }
    }
}
