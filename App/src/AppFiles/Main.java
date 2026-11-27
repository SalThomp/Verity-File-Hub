import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Note (Sal): Find some way to make the unique user id static/auto-applied to all tables 
//So that the user doesn't have to manually input it for every table entry
//this would also make the possibility of having multiple users on the same database easier

//Note (Sal): Confirmed that the database is being created and initialized correctly
//And that data saved to tables remains after the program is closed and reopened

//Note (Sal): Currently, value changes/information updates/deletions are controlled entirely by numerical values
//I don't know enough about GUI design to know how or if things need to be changed for adaptability, but for now it works
//Let me know if anything needs to be adjusted or updated for GUI compatibility

public class Main {
    public static void main(String[] args) {
        // Initializes the database if it does not already exist on local machine
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.initializeDatabase();

    }
}
