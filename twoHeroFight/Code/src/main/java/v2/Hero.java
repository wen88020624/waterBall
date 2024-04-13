package v2;

public class Hero {
    private int hp = 500;
    private final String name;
    private final AttackType attackType;

    public Hero(String name, AttackType attackType) {
        this.name = name;
        this.attackType = attackType;
    }

    public void attack(Hero hero) {
        attackType.attack(this, hero);
    }

    void damage(int damage) {
        setHp(this.getHp() - damage);
        System.out.printf("英雄 %s 受到 %d 的傷害, 生命值剩下 %d \n", name, damage, hp);
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}
