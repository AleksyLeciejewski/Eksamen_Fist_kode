package Items;

public class Shields implements WeaponType {
    public String name;

    public Shields(String name) {
        this.name = name;
    }

    @Override
    public String getWeaponType(){
        return "One-handed";
    }
}
