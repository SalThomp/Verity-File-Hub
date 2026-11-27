import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    // Database string
    String url = "jdbc:sqlite:Verity.db";
    
    // Method to Initilize entire database/creaates tables if they do not already exist
    public void initializeDatabase() {

        //Below statement deletes table if it exists/if the initial values are not correct
        //String dropTable = "DROP TABLE IF EXISTS [table name]];";

        //Creates table for storing user information, includes unique id, username, and password values. Can be adjusted to include email if needed
        String createUserTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY,
                userN TEXT NOT NULL,
                passW TEXT NOT NULL UNIQUE
            );
            """;

        //Creates table for storing task information, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createTasksTable = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY,
                taskName TEXT NOT NULL,
                taskDesc TEXT NOT NULL,
                taskDueDate TEXT NOT NULL,
                taskStatus TEXT NOT NULL,
                userId INTEGER NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;

        //Creates table for storing event information, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createEventsTable = """
            CREATE TABLE IF NOT EXISTS events (
                id INTEGER PRIMARY KEY,
                eventName TEXT NOT NULL,
                eventDesc TEXT NOT NULL,
                eventDate TEXT NOT NULL,
                userId INTEGER NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;

        //Creates table for storing note information, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createNotesTable = """
            CREATE TABLE IF NOT EXISTS notes (
                id INTEGER PRIMARY KEY,
                noteName TEXT NOT NULL,
                noteContent TEXT NOT NULL,
                userId INTEGER NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;

        //Creates table for storing goal information, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createGoalsTable = """
            CREATE TABLE IF NOT EXISTS goals (
                id INTEGER PRIMARY KEY,
                goalName TEXT NOT NULL,
                goalDesc TEXT NOT NULL,
                goalDueDate TEXT NOT NULL,
                goalStatus TEXT NOT NULL,
                userId INTEGER NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;
        
        //Creates table for storing reminder information, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createRemindersTable = """
            CREATE TABLE IF NOT EXISTS reminders (
                id INTEGER PRIMARY KEY,
                reminderName TEXT NOT NULL,
                reminderDesc TEXT NOT NULL,
                reminderDate TEXT NOT NULL,
                userId INTEGER NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;

        //Creates table for generating categories, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createCategoriesTable = """
            CREATE TABLE IF NOT EXISTS categories (
                id INTEGER PRIMARY KEY,
                categoryName TEXT NOT NULL,
                categoryDesc TEXT NOT NULL,
                userId INTEGER NOT NULL,
                taskId INTEGER NOT NULL,
                categoryId INTEGER NOT NULL,
                FOREIGN KEY (taskId) REFERENCES tasks(id),
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;

        //Creates table for storing file information, already designed to be user specific. Can be adjusted to include more or different information if needed.
        String createFilesTable = """
            CREATE TABLE IF NOT EXISTS files (
                id INTEGER PRIMARY KEY,
                fileName TEXT NOT NULL,
                filePath TEXT NOT NULL,
                userId INTEGER NOT NULL,
                FOREIGN KEY (userId) REFERENCES users(id)
            );
            """;

        //Executes the above statements to create tables if they do not already exist
        try (Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement()) {

            if (conn != null) {
                statement.execute(createUserTable);
                statement.execute(createTasksTable);
                statement.execute(createEventsTable);
                statement.execute(createNotesTable);
                statement.execute(createGoalsTable);
                statement.execute(createRemindersTable);
                statement.execute(createCategoriesTable);
                statement.execute(createFilesTable);
            }

        //Catches any error that might be causes from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
        
    }

}
