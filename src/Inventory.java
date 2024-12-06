import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    Scanner brugerInput = new Scanner(System.in);
    private int availableSlots;
    private int maxSlots = 32;
    private double totalWeight;
    private ArrayList<Item> inventoryList;

    public Inventory(int maxSlots, double totalWeight){
    this.maxSlots = maxSlots;
    this.availableSlots = maxSlots;
    this.inventoryList = new ArrayList<>();
    }

//addItem skal opdeles i addWeapon, addArmor, addConsumable osv. Hver metode skal referere til sin respektive tabel.
    /*
    public void addItem(Item item) {
        String sql = "INSERT INTO  (name, MaxStack, currentDrinks) VALUES (?, ?, ?)";
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
                System.out.println("En ny item er nu tilføjet til dit inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }

     */
    public void addWeapon(Weapon weapon) {
        String sql = "INSERT INTO  (name, MaxStack, weight, damage) VALUES (?, ?, ?, ?, ?)";
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
                System.out.println("Et nyt våben er nu tilføjet til dit inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }

    public void addArmor(Armor armor) {
        String sql = "INSERT INTO  (name, MaxStack, weight, defense) VALUES (?, ?, ?, ?, ?)";
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
                System.out.println("En ny rustning er nu tilføjet til dit inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }

    public void addConsumable(Consumable consumable) {
        String sql = "INSERT INTO  (name, MaxStack, weight, duration, effect) VALUES (?, ?, ?, ?, ?, ?)";
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
                System.out.println("En ny consumable er nu tilføjet til dit inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }



    public void removeItem(Item item) {
        //Remove item, database logik
        String sql = "DELETE FROM InventoryRepository WHERE name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, item.getName());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Genstand(e) slettet succesfuldt.");
            } else {
                System.out.println("Ingen genstand(e) fundet med dette navn");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Fejl ved sletning af genstand(e)");

        }
        //Spiller logik for removeItem

    }


    public void showInventory(){
        //show items in inventory

    }

    public double calcTotalWeight(){


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

    return maxSlots;
    }

 */

    public int addSlots(){

        System.out.println("Du har nu valgt at tilføje items til dit inventory");
        System.out.println("Angiv, hvor mange slots du vil tilføje: ");

    int moreSlots = brugerInput.nextInt();

        if(moreSlots <= 0){
            System.out.println("Du kan ikke tilføje 0 slots");
        return maxSlots;
        }

    this.maxSlots += moreSlots;

        System.out.println("Du har nu udvidet din inventory med " + moreSlots + "pladser");
        System.out.println("Din nye kapacitet er nu opgraderet til: " + maxSlots + "!");

    return maxSlots;
    }

}

