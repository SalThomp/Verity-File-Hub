import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TasksCRUD {
    
    public TasksCRUD() {
    }

    // Creates new task in database with chosen task name, description, due date, status, and places it under specific user id
    public void createTask(String taskName, String taskDesc, String taskDueDate, String taskStatus, int userId) {
        String url = "jdbc:sqlite:Verity.db";
        String insertTask = "INSERT INTO tasks (taskName, taskDesc, taskDueDate, taskStatus, userId) VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(insertTask)) {
            pstmt.setString(1, taskName);
            pstmt.setString(2, taskDesc);
            pstmt.setString(3, taskDueDate);
            pstmt.setString(4, taskStatus);
            pstmt.setInt(5, userId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }

    //Updates task info in database using unique id, might need to be adjusted to allow changes to individual fields at user discretion
    public void updateTask(int taskId, String newTaskName, String newTaskDesc, String newTaskDueDate, String newTaskStatus) {
        String url = "jdbc:sqlite:Verity.db";
        String updateTask = "UPDATE tasks SET taskName = ?, taskDesc = ?, taskDueDate = ?, taskStatus = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(updateTask)) {
            pstmt.setString(1, newTaskName);
            pstmt.setString(2, newTaskDesc);
            pstmt.setString(3, newTaskDueDate);
            pstmt.setString(4, newTaskStatus);
            pstmt.setInt(5, taskId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Deletes task from database using unique id number
    public void deleteTask(int taskId) {
        String url = "jdbc:sqlite:Verity.db";
        String deleteTask = "DELETE FROM tasks WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(deleteTask)) {
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
        
        //Catches any error that might be caused from the above statements
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
