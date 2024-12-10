package Items;

import java.util.Random;

public class Weapon extends Item implements Reforge {

    Random reforgeSetter = new Random();

    public Weapon(String name,int itemID,double weight,boolean isStackable,int maxStack, double damage){
        super(name, itemID, weight, isStackable, maxStack);
        this.damage = damage;
    }
//gennem tabel-id refererer vi til den passende tabel.
    double damage;

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public void ReforgeStats() {
        int valg = brugerinput.nextInt();
        System.out.println("You have chosen to reforge the stats on your weapon");
        System.out.println("Select the stats you'd like to reforge");

        switch(valg) { //Implementerer en switch for fleksibilitet, hvis vi tilføjer stats i fremtiden

            case 1: //damage
                System.out.println("You have chosen to reforge the damage attribute on your weapon");
                System.out.println("This transaction will cost you XX gold. Do you want to continue?"); //Lod vær' med at implementere brugerinput prompts for at det kan implementeres i gui

            double newDamage = getDamage() + reforgeSetter.nextDouble() * 14; //Påsætter en begrænsning for værdierne. Her er det mellem 1 og 15
            setDamage(newDamage);

            break;

            case 2: //weight
                System.out.println("You have chosen to reforge the wieght of your weapon");
                System.out.println("This transaction will cost you XX gold. Do you want to continue?"); //Lod vær' med at implementere brugerinput prompts for at det kan implementeres i gui

            double newWeight = getWeight() + reforgeSetter.nextDouble() * 5; //Påsætter en begrænsning for værdierne. Her er det mellem 1 og 6
            setWeight(newWeight);

                System.out.println("Your weapon now weighs: " + newWeight);

            break;

            //case 3:
        }
    }
}
