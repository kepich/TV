package Source.Menu.Modify;

import Source.Menu.AppState;
import Source.Menu.StartMenu;

import java.rmi.UnexpectedException;

public class ModifyMenu extends AppState {
    @Override
    protected void printMenu() {
        System.out.println("Choose modifying struct:");
        System.out.println("1. Acid");
        System.out.println("2. Gene");
        System.out.println("3. Chain");
        System.out.println("4. Back");
    }

    @Override
    protected AppState getNextMenu(String nextMenuNumber) {
        return switch (nextMenuNumber) {
            case "1" -> new AcidModifyMenu();
            case "2" -> new GeneModifyMenu();
            case "3" -> new ChainModifyMenu();
            case "4" -> new StartMenu();
            default -> throw new RuntimeException();
        };
    }
}
