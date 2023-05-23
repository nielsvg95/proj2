import java.sql.*;
import java.util.Scanner;

class Login {
    public void loginText() {
        boolean breakloop = true;

        Scanner scanner = new Scanner(System.in);
        String jdbcURL = "jdbc:sqlite:userinfo.db";

        System.out.println("Username:");
        String username = scanner.nextLine();

        while (breakloop) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL);

                PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
                statement.setString(1, username);

                ResultSet result = statement.executeQuery();


                String passwordDB = result.getString("password");
                System.out.println("Password:");
                String passwordInput = scanner.nextLine();

                if (passwordInput.equals(passwordDB)) {
                    System.out.println("Succes!");
                }
                else {
                    System.out.println("Wrong!");
                }

                breakloop = false;
                break;
            } catch (SQLException e) {
                System.out.println("Error connecting to SQLite database");
                e.printStackTrace();
                breakloop = false;
                break;
            }
        }

    }

}
