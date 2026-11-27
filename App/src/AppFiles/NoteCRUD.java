import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class NoteCRUD {
    public NoteCRUD() {

    }

    // Creates new note in database with chosen title and content, and places it under specific user id
    public void createNote(String noteTitle, String noteContent, int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertNote = "INSERT INTO notes (noteTitle, noteContent, userId) VALUES (?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertNote)) {

            pstmt.setString(1, noteTitle);
            pstmt.setString(2, noteContent);
            pstmt.setInt(3, userId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    //Updates note info in database using unique id, might need to be adjusted to allow changes to individual fields at user discretion
    public void updateNote(int noteId, String newNoteTitle, String newNoteContent) {
        String url = "jdbc:sqlite:Verity.db";
        String updateNote = "UPDATE notes SET noteTitle = ?, noteContent = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(updateNote)) {

            pstmt.setString(1, newNoteTitle);
            pstmt.setString(2, newNoteContent);
            pstmt.setInt(3, noteId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    //Deletes note from database using unique id number
    public void deleteNote(int noteId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteNote = "DELETE FROM notes WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(deleteNote)) {

            pstmt.setInt(1, noteId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

}
