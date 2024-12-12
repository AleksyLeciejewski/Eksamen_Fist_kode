package Items;

public class HeadArmor extends Item implements ItemType {
    public String name;

    public HeadArmor(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getItemType(){
        return "Head Armor";
    }
}
