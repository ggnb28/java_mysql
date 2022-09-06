import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiniProhectConnectMysql {
    public static void main(String[] args) {
        // run MySQL Workbench
        // connect to DataBase
        // Hostname: localhost port: 3306
        // Username: root
        // Default Schema : world
        // password : tbrs00002b
        // access to 'World' DB
        final String DB_URL = "jdbc:mysql://localhost/world";
        final String USER = "root";
        final String PASS = "tbrs00002b";
        String QUERY = "select ID,Name,Population " +
                "from country " +
                "where 1 = 1 " +
                "and Name Like '%an%' ";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            // insert
            // int id = 323214;
            QUERY = "insert into city(ID, Name, CountryCode, District, Population ) " +
                    "values (98765, 'Name', 'AFG', 'District', 500 ) ";
            int val = stmt.executeUpdate(QUERY);
            // select
            QUERY = "select ID, Name, CountryCode, District, Population " +
                    "from city " +
                    "where Name = 'Name' ";
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.println(", Population: " + rs.getInt("Population"));
            }
            // update
            QUERY = "update city " +
                    "set Population = 2000 " +
                    "where Name = 'Name' ";
            val = stmt.executeUpdate(QUERY);

            // select
            System.out.println();    

            // delete
            QUERY = "delete from city " +
                    "where Name = 'Name' ";
            val = stmt.executeUpdate(QUERY);

            // select
            System.out.println();  


            // 새로운 query
            rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.println(", Population: " + rs.getInt("Population"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Make new SQL tab for executing query
        // Select * from City
        // print World.City

        return;
    }

}