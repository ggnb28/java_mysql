import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiniProhectConnectMysql {
    public static void main(String[] args) {
        // run MySQL Workbench
        // connect to DataBase
        // Hostname: localhost  port: 3306
        // Username: root
        // Default Schema : world
        // password : tbrs00002b
        // access to 'World' DB
        final String DB_URL = "jdbc:mysql://localhost/world";
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String QUERY = "select ID,Name,Population " +
                        "from city " +
                        "where 1 = 1 " +
                        "and Population >=9230000 ";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Population: " + rs.getInt("Population"));
             }
             
        }catch (SQLException e) {
            e.printStackTrace(); 
    }
        
        // Make new SQL tab for executing query
        // Select * from City
        // print World.City


        return;
    }
    
}