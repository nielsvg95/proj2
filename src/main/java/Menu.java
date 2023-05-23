import java.util.Scanner;

public class Menu {
    public void menuText() {
        Scanner scanner = new Scanner(System.in);
        Change change = new Change();
        Add add = new Add();
        Login login = new Login();

        System.out.println("Do you want to edit an account or add a new one? \n'login', 'edit' or 'new'");
        String choice = scanner.nextLine();

        boolean breakloop = true;
        while (breakloop) {
            switch (choice) {
                case "edit":
                    change.changeInfo();
                    breakloop = false;
                    break;
                case "new":
                    add.addToDatabase();
                    breakloop = false;
                    break;
                case "login":
                    login.loginText();
                    breakloop = false;
                    break;
            }
        }
    }
}
