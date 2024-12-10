package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/InventoryRepository";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            // DriverManager håndterer forbindelsen til databasen.
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Hvis noget går galt, udskrives fejlen i konsollen.
            e.printStackTrace();
            return null; // Returner null, hvis forbindelsen mislykkes.
        }
    }
}
