package Items;

public class TwoHandsItem extends Item implements ItemType {
    public String name;


    public TwoHandsItem(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getItemType() {
        return "Two Hands";
    }
}
