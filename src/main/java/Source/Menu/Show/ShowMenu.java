package Source.Menu.Show;

import Source.Menu.AppState;
import Source.Menu.StartMenu;

public class ShowMenu extends AppState {
    @Override
    protected void printMenu() {
        printAcids();
        printGenes();
        printChains();

        System.out.println("Press any key to return to main menu:");
    }

    @Override
    protected AppState getNextMenu(String nextMenuNumber) {
        return new StartMenu();
    }
}
