package v2;

public class Hero {
    private final String name;
    private final AttackType attackType;
    private int hp = 500;

    public Hero(String name, AttackType attackType) {
        this.name = name;
        this.attackType = attackType;
    }

    public void attack(Hero defender) {
        attackType.attack(this, defender);
        System.out.println(defender.getName() + " remain hp: " + defender.getHp());
    }

    public void damage(Hero defender, int damage) {
        defender.setHp(defender.getHp() - damage);
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    };

}
