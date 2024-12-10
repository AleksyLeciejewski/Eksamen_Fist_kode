package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private static String URL = "jdbc:mysql://localhost:3306/Player";

    private static String user = "root";

    private static String passWord = "RootRoot";

    private static DatabaseConnection instance;


    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public static Connection getConnection(){

        try{
            return DriverManager.getConnection(URL, user, passWord);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }



}
