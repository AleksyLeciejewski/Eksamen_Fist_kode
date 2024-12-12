package Items;

public class LegsArmor extends Item implements ItemType {
    public String name;


    public LegsArmor(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getItemType(){
        return "LegsArmor";
    }
}
