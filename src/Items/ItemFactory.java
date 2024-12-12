package Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {
    private static final List<Item> items = new ArrayList<>();
/*Fuck det her lorte pikke pisse pis
    static {
        items.add(new OneHandWeapon(1,"Sword",8,1,false,0));
        items.add(new TwoHandsWeapon());
        items.add(new Consumable("Potion", 3, 0.5, true, 10, "Heal", 30));
        items.add(new Consumable("Elixir", 4, 0.3, true, 5, "Mana", 20));
        items.add(new ChestArmor("Platemail"));
        items.add(new ShoulderArmor("Leather Shoulder Pads"));
        items.add(new LegsArmor("Leather leggings"));
        items.add(new Shields("Wooden Shield"));
        items.add(new HeadArmor("Wooden Helmet"));
    }

    public static Item getRandomItem() {
        Random random = new Random();
        return items.get(random.nextInt(items.size()));
    }
}

 */