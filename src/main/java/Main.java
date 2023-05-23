public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Menu menu = new Menu();
        Login login = new Login();

        database.printAll();
        menu.menuText();


        database.printAll();
    }
}
