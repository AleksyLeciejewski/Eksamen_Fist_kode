package Items;

public class TwoHandsWeapon implements WeaponType {
    public String name;


    public twoHandsWeapon(String name) {
        this.name = name;
    }

    @Override
    public String getWeaponType() {
        return "Two Hands";
    }
}
