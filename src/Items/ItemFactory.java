package Items;
import Items.ItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {
    private static final List<Item> items = new ArrayList<>();


    static {
        items.add(new OneHandItem(1, "Sword", 8, 1, false, 0));
        items.add(new TwoHandsItem(2, "Greatsword", 12, 2, false, 0));
        items.add(new Consumable("Potion", 3, 0.5, true, 10, "Heal", 30));
        items.add(new Consumable("Elixir", 4, 0.3, true, 5, "Mana", 20));
        items.add(new ChestArmor(5, "Platemail", 15, 1, false, 0));
        items.add(new ShoulderArmor(6, "Leather Shoulder Pads", 5, 1, false, 0));
        items.add(new LegsArmor(7, "Leather Leggings", 7, 1, false, 0));
        items.add(new Shields(8, "Wooden Shield", 10, 1, false, 0));
        items.add(new HeadArmor(9, "Wooden Helmet", 3, 1, false, 0));
    }

    public static Item getRandomItem() {
        Random random = new Random();
        return items.get(random.nextInt(items.size()));
    }
}