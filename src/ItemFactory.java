import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {
    private static final List<Item> items = new ArrayList<>();

    static {
        items.add(new Weapon("Sword", 1, 1, false, 1, 10.0));
        items.add(new Weapon("Axe", 2, 1.5, false, 1, 12.0));
        items.add(new Consumable("Potion", 3, 0.5, true, 10, "Heal", 30));
        items.add(new Consumable("Elixir", 4, 0.3, true, 5, "Mana", 20));
        // Add more items as needed
    }

    public static Item getRandomItem() {
        Random random = new Random();
        return items.get(random.nextInt(items.size()));
    }
}