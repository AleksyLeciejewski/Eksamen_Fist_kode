import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inventory {

    private int availableSlots;
    private int maxSlots;
    private double totalWeight;
    private ArrayList<Item> inventoryList;

    public Inventory(int maxSlots, double totalWeight){
    this.maxSlots = maxSlots;
    this.availableSlots = maxSlots;
    this.inventoryList = new ArrayList<>();
    }
//addItem skal opdeles i addWeapon, addArmor, addConsumable osv. Hver metode skal referere til sin respektive tabel.
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
    public void addWeapon(Weapon weapon) {
        String sql = "INSERT INTO  (name, MaxStack, weight, damage) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Indsætter værdier i placeholders i SQL-sætningen.
            preparedStatement.setString(1, weapon.getName());
            preparedStatement.setInt(2, weapon.getItemID());
            preparedStatement.setInt(3, weapon.getMaxStack());
            preparedStatement.setDouble(4, weapon.getWeight());
            preparedStatement.setBoolean(5, weapon.isStackable());
            preparedStatement.setDouble(6, weapon.getDamage());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("En ny item er nu tilføjet til dit inventory!");
            }
        } catch (SQLException e) {
            // Håndterer SQL-relaterede fejl.
            e.printStackTrace();
        }
    }


        }
    }

    public void removeItem(Item item) {
        //Remove item, database logik
        String sql "DELETE FROM InventoryRepository WHERE name = ?";

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

    public int addSlots(){

    return maxSlots;}


}
