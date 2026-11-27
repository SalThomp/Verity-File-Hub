import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserCRUD {
    
    public UserCRUD() {
    }

    // Creates new user in database with chosen username and password
    public void createUser(String userName, String passWord) {
        String url = "jdbc:sqlite:Verity.db";
        String insertUser = "INSERT INTO users (userN, passW) VALUES (?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(insertUser)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, passWord);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }

    //Do we need a readUser method? May be useful for testing reasons but it probably doesn't make sense for the finished product

    //Updates user info in database using unique id, might need to be adjusted to allow changes to only one of the two fields
    public void updateUser(int userId, String newUserName, String newPassWord) {
        String url = "jdbc:sqlite:Verity.db";
        String updateUser = "UPDATE users SET userN = ?, passW = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(updateUser)) {
            pstmt.setString(1, newUserName);
            pstmt.setString(2, newPassWord);
            pstmt.setInt(3, userId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Deletes user from database using unique id number
    public void deleteUser(int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteUser = "DELETE FROM users WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(deleteUser)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
