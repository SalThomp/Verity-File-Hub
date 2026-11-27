import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Calendar;;

public class TimeDateTracker {
    public TimeDateTracker() {
    }

    // Method to get current date and time from system
    public String getCurrentDateTime() {
        Date date = new java.util.Date();
        return date.toString();
    }

    // Method to get current month from system (for Calender implementation), returns a number value equvalent to the month 
    // Adjust so that it returns the month name instead of number
    public String getMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1; // Months are zero-based, so we add 1
        return String.valueOf(month);
    }

    // Write logic for comparing date/time string from database table fields to determine 
    // if reminder/task/etc needs to pop-up or if it said item is due/overdue
    public void compareDateTime(String dateTime1, String dateTime2) {
        // Implement comparison logic here
    }

}
