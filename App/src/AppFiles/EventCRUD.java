import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class EventCRUD {
    public EventCRUD() {
    }

    // Creates a new event in the database with the chosen name, description, date, and places it under a specific user id
    public void createEvent(String eventName, String eventDesc, String eventDate, int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertEvent = "INSERT INTO events (eventName, eventDesc, eventDate, userId) VALUES (?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertEvent)) {

            pstmt.setString(1, eventName);
            pstmt.setString(2, eventDesc);
            pstmt.setString(3, eventDate);
            pstmt.setInt(4, userId);
            pstmt.executeUpdate();

        // Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    // Updates event info in the database using a unique id, might need to be adjusted to allow changes to individual fields at user discretion
    public void updateEvent(int eventId, String newEventName, String newEventDesc, String newEventDate) {
        String url = "jdbc:sqlite:Verity.db";
        String updateEvent = "UPDATE events SET eventName = ?, eventDesc = ?, eventDate = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(updateEvent)) {

            pstmt.setString(1, newEventName);
            pstmt.setString(2, newEventDesc);
            pstmt.setString(3, newEventDate);
            pstmt.setInt(4, eventId);
            pstmt.executeUpdate();

        // Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    // Deletes an event from the database using a unique id number
    public void deleteEvent(int eventId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteEvent = "DELETE FROM events WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(deleteEvent)) {

            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();

        // Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

}
