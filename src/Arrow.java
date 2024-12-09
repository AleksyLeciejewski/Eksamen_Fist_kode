public class Arrow extends Consumable{
    public Arrow(String name, int itemID, double weight, boolean isStackable, int maxStack, String effect, int duration) {
        super(name, itemID, weight, isStackable, maxStack, effect, duration);
    }

    public void damageWithEffect(){
        System.out.println("Dealing damage with effect: " + this.getEffect() + " for " + this.getDuration() + " seconds");
    }

    public void damageWithoutEffect(){
        System.out.println("Dealing damage without effect: " + this.getName());
    }

    public void shoot(){
        System.out.println("Shooting arrow: " + this.getName());
        if(this.getEffect() != null){
            damageWithEffect();
        }else{
            damageWithoutEffect();
        }
    }
}
