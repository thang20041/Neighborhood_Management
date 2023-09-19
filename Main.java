import Town.Town;
import View.Menu;

public class Main {
    public static void main(String[] args) {
        Town khuPho = new Town();
        Menu menu = new Menu(khuPho);
        menu.showMenu();
    }
}