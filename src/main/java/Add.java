import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Add {
    public void addToDatabase() {
        Scanner scanner = new Scanner(System.in);
        String jdbcURL = "jdbc:sqlite:userinfo.db";

        System.out.println("Enter your username");
        String username = scanner.nextLine();

        System.out.println("Enter your password");
        String password = scanner.nextLine();

        System.out.println("Enter your email address");
        String email = scanner.nextLine();

        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "INSERT INTO users(username, password, email) VALUES (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }
    }
}

class Change {
    private final String jdbcURL = "jdbc:sqlite:userinfo.db";
    public void changeInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to change?\n" +
                "           username, password or email?");
        String change = scanner.nextLine();

        switch (change.toLowerCase()){
            case "username":
                changeUsername();
            case "password":
                changePassword();
            case "email":
                changeEmail();
        }
    }
    public void changeUsername() {
        boolean breakloop = true;
        while (breakloop) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL);


                Scanner scanner = new Scanner(System.in);

                System.out.println("old name");
                String oldUsername = scanner.nextLine();

                System.out.println("new name");
                String newUsername = scanner.nextLine();

                String sql = "UPDATE users SET username = ? WHERE username = ? ";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, oldUsername);
                preparedStatement.execute();
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

    public void changePassword() {
        boolean breakloop = true;
        while (breakloop) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL);
                Scanner scanner = new Scanner(System.in);

                System.out.println("current username:");
                String currentUsername = scanner.nextLine();

                System.out.println("new password");
                String newPassword = scanner.nextLine();

                System.out.println("repeat password");
                String repeatPassword = scanner.nextLine();

                if (newPassword.equals(repeatPassword)) {

                    String sql = "UPDATE users SET password = ? WHERE username = ?";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, newPassword);
                    preparedStatement.setString(2, currentUsername);
                    preparedStatement.execute();
                    breakloop = false;
                    break;
                }
                else {
                    breakloop = false;
                    break;
                }

            } catch (SQLException e) {
                System.out.println("Error connecting to SQLite database");
                e.printStackTrace();
                breakloop = false;
                break;
            }
        }
    }

    public void changeEmail() {
        boolean breakloop = true;
        while (breakloop) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL);
                Scanner scanner = new Scanner(System.in);

                System.out.println("current email:");
                String currentEmail = scanner.nextLine();

                System.out.println("new email");
                String newEmail = scanner.nextLine();

                String sql = "UPDATE users SET email = ? WHERE email = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, newEmail);
                preparedStatement.setString(2, currentEmail);
                preparedStatement.execute();
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

