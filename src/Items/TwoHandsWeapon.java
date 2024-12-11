package Items;

public class TwoHandsWeapon extends Item implements WeaponType {
    public String name;


    public TwoHandsWeapon(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }

    @Override
    public String getWeaponType() {
        return "Two Hands";
    }
}
