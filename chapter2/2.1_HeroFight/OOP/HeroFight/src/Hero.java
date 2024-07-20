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
        if (attackType == "waterBall") {
            defender.setHp((int) (defender.getHp() - this.getHp() * 0.5));

        } else if (attackType == "fireBall") {
            for (int i=0; i<=3; i++) {
                defender.setHp((defender.getHp() - 50));
            }

        } else if (attackType == "earth") {
            for (int i=0; i<=10; i++) {
                defender.setHp((defender.getHp() - 20));
            }
        }
        System.out.println(defender.getName() + " remain hp: " + defender.getHp());
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
