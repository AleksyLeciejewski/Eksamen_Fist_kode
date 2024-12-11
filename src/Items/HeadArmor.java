package Items;

public class HeadArmor implements WeaponType {
    public String name;

    public HeadArmor(String name) {
        this.name = "Head Armor";
    }

    @Override
    public String getWeaponType(){
        return "Head Armor";
    }
}
