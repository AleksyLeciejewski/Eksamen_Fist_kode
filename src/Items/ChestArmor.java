package Items;

public class ChestArmor implements WeaponType{
    public String name;

    public ChestArmor(String name){
        this.name = name;

    }

    @Override
    public String getWeaponType(){
        return "Chest Armor";
    }
}
