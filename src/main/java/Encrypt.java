import org.jasypt.util.password.*;

import java.sql.*;

public class Encrypt {
    public String getUserPasswordHash() {
        String jdbcURL = "jdbc:sqlite:userinfo.db";
        while (true) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL);
                String sql = "SELECT password FROM ?";

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    String password = result.getString("password");
                    return password;
                }
            } catch (SQLException e) {
                System.out.println("Error connecting to SQLite database");
                e.printStackTrace();
            }
        }
    }


    public void checkPasswordHash(String inputPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(inputPassword);
        if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) {
            // correct!
        } else {
            // bad login!
        }
    }
}
