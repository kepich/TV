package Source.Menu;

import Source.Menu.Add.AddMenu;
import Source.Menu.Modify.ModifyMenu;
import Source.Menu.Show.ShowMenu;

public class StartMenu extends AppState {
    @Override
    protected void printMenu(){
        System.out.println("Choose menu:");
        System.out.println("1. Add new stricture");
        System.out.println("2. Show all structures");
        System.out.println("3. Modify structures");
        System.out.println("4. Exit");
    }

    @Override
    protected AppState getNextMenu(String nextMenuNumber){
        return switch (nextMenuNumber) {
            case "1" -> new AddMenu();
            case "2" -> new ShowMenu();
            case "3" -> new ModifyMenu();
            case "4" -> null;
            default -> throw new RuntimeException();
        };
    }
}
