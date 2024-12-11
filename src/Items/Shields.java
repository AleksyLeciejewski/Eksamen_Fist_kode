package Items;

public class Shields extends Item implements WeaponType {
    public String name;

    public Shields(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getWeaponType(){
        return "One-handed";
    }
}
