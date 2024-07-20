public class Hero {
    private final String name;
    private final String attackType;
    private int hp = 500;

    public Hero(String name, String attackType) {
        this.name = name;
        this.attackType = attackType;
    }

    public void attack(Hero defender) {
        System.out.println(this.getName() + " attack " + defender.getName());
        switch (attackType) {
            case "waterBall":
                defender.damage((int) (this.getHp() * 0.5));
                break;
            case "fireBall":
                for (int i=0; i<=3; i++) {
                    defender.damage(50);
                }
                break;

            case "earth":
                for (int i=0; i<=10; i++) {
                    defender.damage(20);
                }
                break;
        }
        System.out.println(defender.getName() + " remain hp: " + defender.getHp());
    }

    private void damage(int damage) {
        this.setHp(hp - damage);
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
