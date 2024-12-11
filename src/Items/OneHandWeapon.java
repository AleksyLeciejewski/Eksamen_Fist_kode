package Items;

public class OneHandWeapon implements WeaponType {
    private String name;

    public OneHandWeapon(String name) {
        this.name = name;
    }


    @Override
    public String getWeaponType() {
        return "one-hand";
    }
}
