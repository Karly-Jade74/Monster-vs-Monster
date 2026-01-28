import java.util.Random;

public class CrazyMonster implements Monster {
    private int health;
    private int attackStrength;
    private int damageCount;
    private static final char[] CHARACTERS = {'!', '@', '#', '$', '%', '^', '&', '*', '?'};
    
    public CrazyMonster(int health) {
        this.health = health;
        this.attackStrength = 1;
        this.damageCount = 0;
    }
    
    public String getName() {
        Random rand = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            name.append(CHARACTERS[rand.nextInt(CHARACTERS.length)]);
        }
        return name.toString();
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void takeDamage(int damage) {
        this.health -= damage;
        damageCount++;
        if (damageCount % 2 == 0) {
            attackStrength += damage;
        }
    }
    
    public String attack(Monster other) {
        Random rand = new Random();
        int damage = rand.nextInt(attackStrength) + 1;
        other.takeDamage(damage);
        return String.format("%s attacks %s doing %d damage\n", getName(), other.getName(), damage);
    }
}
