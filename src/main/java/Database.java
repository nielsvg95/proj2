import java.sql.*;

public class Database {
    public void printAll() {

        String jdbcURL = "jdbc:sqlite:userinfo.db";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "SELECT * FROM users";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String name = result.getString("username");
                String password = result.getString("password");
                String email = result.getString("email");

                System.out.println(name + " | " + password + " | " + email);
            }
        } catch(SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace ();
        }
    }
}
