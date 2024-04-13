package v1;

public class Hero {
    private int hp = 500;
    private final String name;
    private final String attackType;

    public Hero(String name, String attackType) {
        this.name = name;
        this.attackType = attackType;
    }

    public void attack(Hero hero) {
        switch (this.attackType) {
            case "WaterBall":
                hero.damage((int) (this.hp * 0.5));
                break;
            case "FireBall":
                for (int i=0; i<3; i++) {
                    hero.damage(50);
                }
                break;
            case "v2.Earth":
                for (int i=0; i<10; i++) {
                    hero.damage(20);
                }
                break;
        }
    }

    private void damage(int damage) {
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
