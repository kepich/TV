package Source.Menu.Add;

import Source.Menu.AppState;
import Source.Structure.Actions.Factory.DNAActionFactory;
import Source.Structure.Actions.Factory.RNAActionFactory;

public class AddMenu extends AppState {
    @Override
    protected void printMenu() {
        System.out.println("Choose struct:");
        System.out.println("1. RNA");
        System.out.println("2. DNA");
        System.out.println("3. Gene");
        System.out.println("4. Chain");
        System.out.println("5. Back");
    }

    @Override
    protected AppState getNextMenu(String nextMenuNumber) {
        return switch (nextMenuNumber) {
            case "1" -> new AddAcidMenu(new RNAActionFactory());
            case "2" -> new AddAcidMenu(new DNAActionFactory());
            case "3" -> new AddGeneMenu();
            case "4" -> new AddChainMenu();
            default -> throw new RuntimeException();
        };
    }
}
