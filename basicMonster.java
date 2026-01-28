public class BasicMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;

    public BasicMonster(String initName, int initHealth, Weapon initWeapon) {
        this.name = initName;
        this.health = initHealth;
        this.weapon = initWeapon;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public String attack(Monster other) {
        int damage = (int) (Math.random() * weapon.getMaxDamage()) + 1;
        other.takeDamage(damage);
        return String.format("%s attacks %s with %s doing %d damage\n", this.name, other.getName(), weapon.getName(), damage);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}



