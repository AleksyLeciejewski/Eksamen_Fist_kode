package Items;

public class Shields extends Item implements ItemType {
    public String name;

    public Shields(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getItemType(){
        return "One-handed";
    }
}
