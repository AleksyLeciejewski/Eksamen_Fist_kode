package Items;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Comparator;



public class Inventory {
    Scanner brugerInput = new Scanner(System.in);
    private int availableSlots;
    private int maxSlots = 32;
    private double totalWeight;
    private static ArrayList<Item> inventoryList;

    public Inventory(int maxSlots, double totalWeight){
    this.maxSlots = maxSlots;
    this.availableSlots = maxSlots;
    this.inventoryList = new ArrayList<>();
    }

//addItem skal kaldes ved hver add item. Hver metode skal referere til sin respektive tabel.
    public static void addItem(Item item) {
        String sql = "INSERT INTO inventorylist (name, MaxStack, currentDrinks) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Indsætter værdier i placeholders i SQL-sætningen.
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getItemID());
            preparedStatement.setInt(3, item.getMaxStack());
            preparedStatement.setDouble(4, item.getWeight());
            preparedStatement.setBoolean(5, item.isStackable());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new item has been added to your inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }
    public void addWeapon(Weapon weapon) {
        addItem(weapon);
        String sql = "INSERT INTO weapons (name, MaxStack, weight, damage) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Indsætter værdier i placeholders i SQL-sætningen.
            preparedStatement.setString(1, weapon.getName());
            preparedStatement.setInt(2, weapon.getMaxStack());
            preparedStatement.setDouble(3, weapon.getWeight());
            preparedStatement.setBoolean(4, weapon.isStackable());
            preparedStatement.setDouble(5, weapon.getDamage());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new weapon has been added to your inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }

    public void addArmor(Armor armor) {
        addItem(armor);
        String sql = "INSERT INTO armor (name, MaxStack, weight, defense) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Indsætter værdier i placeholders i SQL-sætningen.
            preparedStatement.setString(1, armor.getName());
            preparedStatement.setInt(2, armor.getMaxStack());
            preparedStatement.setDouble(3, armor.getWeight());
            preparedStatement.setBoolean(4, armor.isStackable());
            preparedStatement.setDouble(5, armor.getDefense());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new armor piece has been added to your inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }

    public void addConsumable(Consumable consumable) throws SQLException {
        addItem(consumable);
        String sql = "INSERT INTO consumable (name, MaxStack, weight, duration, effect) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Indsætter værdier i placeholders i SQL-sætningen.
            preparedStatement.setString(1, consumable.getName());
            preparedStatement.setInt(2, consumable.getMaxStack());
            preparedStatement.setDouble(3, consumable.getWeight());
            preparedStatement.setBoolean(4, consumable.isStackable());
            preparedStatement.setDouble(5, consumable.getDuration());
            preparedStatement.setString(6, consumable.getEffect());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new consumable has been added to your inventory!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeItemBySlot(int slot) {

        if (slot < 1 || slot > inventoryList.size()) {
            System.out.println("Invalid slot number.");
            return;
        }

        Item itemToRemove = inventoryList.get(slot - 1);
        if (itemToRemove == null) {
            System.out.println("Slot is empty.");
            return;
        }

        String sql = "DELETE FROM Inventory WHERE itemID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, itemToRemove.getItemID());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                System.out.printf("The item '%s' has been removed from slot %d.%n",
                        itemToRemove.getName(), slot);


                inventoryList.remove(slot - 1);
            } else {

                System.out.printf("Could not remove the item '%s' in the database.%n",
                        itemToRemove.getName());
            }

        } catch (SQLException e) {

            System.err.printf("Error removing item from slot %d: %s%n", slot, e.getMessage());
        }
    }


    public void showInventory() {
        String sql = "SELECT name, maxStack, weight, isStackable FROM Inventory";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int maxStack = resultSet.getInt("maxStack");
                double weight = resultSet.getDouble("weight");
                boolean isStackable = resultSet.getBoolean("isStackable");

                System.out.printf("Items.Item: %s, Max Stack: %d, Weight: %.2f, Is Stackable: %b%n", name, maxStack, weight, isStackable);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error showing inventory: " + e.getMessage());
        }
    }

    public class Quicksort {
        public static <T> void quicksort(List<T> list, int low, int high, Comparator<T> comparator) {
            if (low < high) {

                int pivotIndex = partition(list, low, high, comparator);

                quicksort(list, low, pivotIndex - 1, comparator);

                quicksort(list, pivotIndex + 1, high, comparator);
            }
        }

        private static <T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {
            T pivot = list.get(high);
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (comparator.compare(list.get(j), pivot) <= 0) {
                    i++;
                    // Byt elementerne
                    swap(list, i, j);
                }
            }

            swap(list, i + 1, high);
            return i + 1;
        }

        private static <T> void swap(List<T> list, int i, int j) {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void sortInventory(){

    }


    public double calcTotalWeight(){
        double totalWeight = 0;
        double maxWeight = 50;
        for (Item item : inventoryList) {
            totalWeight += item.getWeight();
        }
        if (totalWeight > maxWeight){
            System.out.println("Your inventory is full! Sell or discard items to free up space.");
        } else {
            System.out.println("The total weight of your inventory is: " + totalWeight);
        }
    return totalWeight;
    }
/*
    public int addSlots(int moreSlots){

    if(moreSlots <= 0){
            System.out.println("Du kan ikke tilføje 0 slots");
    return maxSlots;
    }

    this.maxSlots += moreSlots;

        System.out.println("Du har nu udvidet din inventory med " + moreSlots + "pladser");
        System.out.println("Din nuværende kapacitet er nu opgraderet til: " + maxSlots + "!");
        System.out.println("Dit inventory er fyldt! Slet eller sælg items for at frigøre plads");

    return maxSlots;
    }

 */

    public int addSlots(){

        System.out.println("You have chosen to add slots to your inventory");
        System.out.println("How many slots would you like to add: ");

    int moreSlots = brugerInput.nextInt();

        if(moreSlots <= 0){
            System.out.println("You cannot add 0 slots");
        return maxSlots;
        }

    this.maxSlots += moreSlots;

        System.out.println("You have now expanded your inventory by " + moreSlots + "slots");
        System.out.println("Your new capacity is now: " + maxSlots + "!");

    return maxSlots;
    }
}