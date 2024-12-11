package Items;

public class OneHandWeapon extends Item implements WeaponType {
    private String name;

    public OneHandWeapon(int itemID, String name, double weight, int maxStack, boolean isStackable, double defense){
        super(name, itemID, weight, isStackable, maxStack);
    }


    @Override
    public String getWeaponType() {
        return "one-hand";
    }
}
