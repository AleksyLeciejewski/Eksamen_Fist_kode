package Items;

public class ShoulderArmor implements WeaponType {
    public String name;

    public ShoulderArmor(String name) {
        this.name = name;
    }

    @Override
    public String getWeaponType(){
        return "Shoulder Armor";
    }
}
