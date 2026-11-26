import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Initializes the database if it does not already exist on local machine
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.initializeDatabase();
    
    }
}
