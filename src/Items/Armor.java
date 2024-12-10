package Items;

public class Armor extends Item implements Reforge {


    public Armor(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
        this.defense = defense;
   }
    double defense;

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    @Override
    public void ReforgeWeight() {
        System.out.println("You have chosen to reforge the wieght of your item");
    }

    @Override
    public void ReforgeStats() {

    }


}
