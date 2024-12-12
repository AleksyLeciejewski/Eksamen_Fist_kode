package Items;

public class ChestArmor extends Item implements WeaponType{
    public String name;

    public ChestArmor(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);

    }

    @Override
    public String getWeaponType(){
        return "Chest Armor";
    }
}
