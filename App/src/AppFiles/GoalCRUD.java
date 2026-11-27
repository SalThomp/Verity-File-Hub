import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class GoalCRUD {
    public GoalCRUD() {
    }

    // Creates a new goal in the database with the specified goal name, description, due date, status, and places it under specific user id
    public void createGoal(String goalName, String goalDesc, String goalDueDate, String goalStatus, int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertGoal = "INSERT INTO goals (goalName, goalDesc, goalDueDate, goalStatus, userId) VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertGoal)) {
            pstmt.setString(1, goalName);
            pstmt.setString(2, goalDesc);
            pstmt.setString(3, goalDueDate);
            pstmt.setString(4, goalStatus);
            pstmt.setInt(5, userId);
            pstmt.executeUpdate();

        // Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Updates goal info in the database using unique id, might need to be adjusted to allow changes to individual fields at user discretion
    public void updateGoal(int goalId, String newGoalName, String newGoalDesc, String newGoalDueDate, String newGoalStatus) {
        String url = "jdbc:sqlite:Verity.db";
        String updateGoal = "UPDATE goals SET goalName = ?, goalDesc = ?, goalDueDate = ?, goalStatus = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(updateGoal)) {
            pstmt.setString(1, newGoalName);
            pstmt.setString(2, newGoalDesc);
            pstmt.setString(3, newGoalDueDate);
            pstmt.setString(4, newGoalStatus);
            pstmt.setInt(5, goalId);
            pstmt.executeUpdate();

        // Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Deletes goal from the database using unique id number
    public void deleteGoal(int goalId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteGoal = "DELETE FROM goals WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(deleteGoal)) {
            pstmt.setInt(1, goalId);
            pstmt.executeUpdate();

        // Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
