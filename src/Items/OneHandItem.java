package Items;

public class OneHandItem extends Item implements ItemType {
    private String name;

    public OneHandItem(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }


    @Override
    public String getItemType() {
        return "one-hand";
    }
}
