import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class RemindersCRUD {

    public RemindersCRUD() {
    }

    // Creates new reminder in database with chosen reminder name, description, due date, status, and places it under specific user id
    public void createReminder(String reminderName, String reminderDesc, String reminderDueDate, String reminderStatus, int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertReminder = "INSERT INTO reminders (reminderName, reminderDesc, reminderDueDate, reminderStatus, userId) VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(insertReminder)) {
            pstmt.setString(1, reminderName);
            pstmt.setString(2, reminderDesc);
            pstmt.setString(3, reminderDueDate);
            pstmt.setString(4, reminderStatus);
            pstmt.setInt(5, userId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Updates reminder info in database using unique id, might need to be adjusted to allow changes to individual fields at user discretion
    public void updateReminder(int reminderId, String newReminderName, String newReminderDesc, String newReminderDueDate, String newReminderStatus) {
        String url = "jdbc:sqlite:Verity.db";
        String updateReminder = "UPDATE reminders SET reminderName = ?, reminderDesc = ?, reminderDueDate = ?, reminderStatus = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(updateReminder)) {
            pstmt.setString(1, newReminderName);
            pstmt.setString(2, newReminderDesc);
            pstmt.setString(3, newReminderDueDate);
            pstmt.setString(4, newReminderStatus);
            pstmt.setInt(5, reminderId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Deletes reminder from database using unique id number
    public void deleteReminder(int reminderId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteReminder = "DELETE FROM reminders WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(deleteReminder)) {
            pstmt.setInt(1, reminderId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
