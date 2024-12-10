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

    }

    @Override
    public void ReforgeStats() {

    }


}
