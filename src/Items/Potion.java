package Items;

public class Potion extends Consumable {
    public Potion(String name, int itemID, double weight, boolean isStackable, int maxStack, String effect, int duration) {
        super(name, itemID, weight, isStackable, maxStack, effect, duration);
    }

    public void applyEffect(){
        System.out.println("Applying effect: " + this.getEffect() + " for " + this.getDuration() + " seconds");
    }

    public void drink(){
        System.out.println("Drinking potion: " + this.getName());
        applyEffect();
    }

    public static Potion createHealthPotion(String name, int itemID, int duration){
        return new Potion("Healing Items.Potion", itemID, 0.5, true, 4, "Healing", 5);
    }

}
