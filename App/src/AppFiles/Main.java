import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Verity.db";

        String createTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY,
                userN TEXT NOT NULL,
                passW TEXT NOT NULL UNIQUE
            );
            """;

       try (Connection conn = DriverManager.getConnection(url); 
       Statement statement = conn.createStatement()) {
        
        if (conn != null){
            statement.execute(createTable);
        }
        
       } catch (SQLException e) {  
        System.err.println(e.getMessage());
       }
    }
}
