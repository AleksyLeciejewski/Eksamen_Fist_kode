package Items;

public class Weapon extends Item implements Reforge {


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

    }

    @Override
    public void ReforgeWeight() {

    }
}