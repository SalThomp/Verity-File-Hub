import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class FileCRUD {
    public FileCRUD() {
    }

    // Insert a new file record into the database
    public void insertFile(int userId, String fileName, String filePath) {  
        String url = "jdbc:sqlite:verity.db";
        String sql = "INSERT INTO files(userId, fileName, filePath) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, fileName);
            pstmt.setString(3, filePath);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    // Update an existing file in the database
    public void updateFile(int fileId, String newFileName, String newFilePath) {
        String url = "jdbc:sqlite:verity.db";
        String sql = "UPDATE files SET fileName = ?, filePath = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newFileName);
            pstmt.setString(2, newFilePath);
            pstmt.setInt(3, fileId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    // Delete a file from the database
    public void deleteFile(int fileId) {
        String url = "jdbc:sqlite:verity.db";
        String sql = "DELETE FROM files WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fileId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

}
