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
        final String QUERY = "select Code,Name,Continent, Region " +
                        "from country " +
                        "where 1 = 1 " +
                        "and Name Like '%an%' ";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Code: " + rs.getString("Code"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Continent: " + rs.getString("Continent"));
                System.out.print(", Region: " + rs.getString("Region"));
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