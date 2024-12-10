import java.sql.Ref;

public class Consumable extends Item implements Reforge {

    public Consumable(String name,int itemID,double weight,boolean isStackable,int maxStack, String effect, int duration){
        super(name, itemID, weight, isStackable, maxStack);
        this.duration = duration;
        this.effect = effect;
    }

    String effect;
    int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public void ReforgeStats() {

    }

    @Override
    public void ReforgeWeight() {

    }
}
