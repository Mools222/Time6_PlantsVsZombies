public class Zombie {

    private int HP = 200;

    static int critCounter = 0;
    static int normalDamageCounter = 0;
    static int critDamageCounter = 0;

    public int getHP() {
        return HP;
    }

    private int critChanceIncreasePerAttackCounter = 9;

    void takeDamage() {

        int damage = (int) (Math.random() * 11);

        int crit = (int) (Math.random() * 100);

        boolean isCrit = false;

        if (crit >= 0 && crit <= critChanceIncreasePerAttackCounter) {
            damage *= 2;
            ++critCounter;
            critChanceIncreasePerAttackCounter = 9;
            isCrit = true;
        }

        HP -= damage;


        if (!isCrit) {
            System.out.println("Zombie took " + damage + " damage");
            normalDamageCounter += damage;
        } else {
            System.out.println("Zombie took " + damage + " crit damage");
            critDamageCounter += damage;
        }

        System.out.println("Plant's remaining HP: " + HP);
        System.out.println();

        ++critChanceIncreasePerAttackCounter;
    }

    void attack(Plant plant) {
        plant.takeDamage();
    }
}
