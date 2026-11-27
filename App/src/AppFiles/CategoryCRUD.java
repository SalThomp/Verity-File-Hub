import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class CategoryCRUD {

    public CategoryCRUD() {

    }

    // Creates new category in database with chosen name and description, and places it under specific user id
    public void createCategory(String categoryName, String categoryDesc, int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertCategory = "INSERT INTO categories (categoryName, categoryDesc, userId) VALUES (?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertCategory)) {

            pstmt.setString(1, categoryName);
            pstmt.setString(2, categoryDesc);
            pstmt.setInt(3, userId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    //Updates category info in database using unique id, might need to be adjusted to allow changes to individual fields at user discretion
    public void updateCategory(int categoryId, String newCategoryName, String newCategoryDesc) {
        String url = "jdbc:sqlite:Verity.db";
        String updateCategory = "UPDATE categories SET categoryName = ?, categoryDesc = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(updateCategory)) {

            pstmt.setString(1, newCategoryName);
            pstmt.setString(2, newCategoryDesc);
            pstmt.setInt(3, categoryId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    //Deletes category from database using unique id number
    public void deleteCategory(int categoryId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteCategory = "DELETE FROM categories WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(deleteCategory)) {

            pstmt.setInt(1, categoryId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }

    // Adds a task to a category in the database using their unique ids
    public void addTaskToCategory(int taskId, int categoryId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertTaskCategory = "INSERT INTO taskCategories (taskId, categoryId) VALUES (?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertTaskCategory)) {

            pstmt.setInt(1, taskId);
            pstmt.setInt(2, categoryId);
            pstmt.executeUpdate();

        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Database Error:" + e.getMessage());
        }
    }
}
