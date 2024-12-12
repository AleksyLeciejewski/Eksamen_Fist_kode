package Items;

public class HeadArmor extends Item implements WeaponType {
    public String name;

    public HeadArmor(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getWeaponType(){
        return "Head Armor";
    }
}
