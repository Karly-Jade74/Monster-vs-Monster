import java.util.Random;

public class MultiAttackMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;
    private int numberOfAttacks;

    public MultiAttackMonster(String n, int h, Weapon w, int nOA) {
        name = n;
        health = h;
        weapon = w;
        numberOfAttacks = nOA;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public String attack(Monster target) {
        Random ran = new Random();
        String str = "";
        for (int i = 0; i < numberOfAttacks; i++) {
            int damage = ran.nextInt(weapon.getMaxDamage()) + 1;
            target.takeDamage(damage);
            str += String.format("%s attacks %s with %s doing %d damage\n", this.name, target.getName(), weapon.getName(), damage);
        }
        return str;
    }
}
