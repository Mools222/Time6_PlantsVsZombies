public class Main {
    public static void main(String[] args) {

        Plant plant = new Plant();
        Zombie zombie = new Zombie();

        while (plant.getHP() > 0 && zombie.getHP() > 0) {

            int whoGoesFirst = (int)(Math.random() * 2);

            if (whoGoesFirst == 0) {
                plant.attack(zombie);
                if (zombie.getHP() <= 0)
                    break;
                zombie.attack(plant);
            }
            else {
                zombie.attack(plant);
                if (plant.getHP() <= 0)
                    break;
                plant.attack(zombie);
            }
        }

        if (plant.getHP() > 0)
            System.out.println("Plant won");
        else if (zombie.getHP() > 0)
            System.out.println("Zombie won");

        System.out.println("\nCrit counter:\nZombie crits: " + Plant.critCounter + "\nPlant crits: " + Zombie.critCounter);

        System.out.println("\nDamage counter:" +
                "\nZombie crit damage: " + Plant.critDamageCounter + "\nZombie normal damage: " + Plant.normalDamageCounter + "\nZombie total damage: " + (Plant.critDamageCounter + Plant.normalDamageCounter) +
                "\nPlant crit damage: " + Zombie.critDamageCounter + "\nPlant normal damage: " + Zombie.normalDamageCounter + "\nPlant total damage: " + (Zombie.critDamageCounter + Zombie.normalDamageCounter));

    }
}
