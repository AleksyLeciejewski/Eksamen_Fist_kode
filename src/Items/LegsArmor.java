package Items;

public class LegsArmor implements WeaponType {
    public String name;

    public LegsArmor(String name){
        this.name = name;
    }

    @Override
    public String getWeaponType(){
        return "LegsArmor";
    }
}
