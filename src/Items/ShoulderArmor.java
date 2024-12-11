package Items;

public class ShoulderArmor extends Item implements WeaponType {
    public String name;

    public ShoulderArmor(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
        this.name = name;
    }


    @Override
    public String getWeaponType(){
        return "Shoulder Armor";
    }
}
