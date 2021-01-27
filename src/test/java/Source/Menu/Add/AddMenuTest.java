package Source.Menu.Add;

import Source.Menu.Modify.AcidModifyMenu;
import Source.Menu.Modify.ChainModifyMenu;
import Source.Menu.Modify.GeneModifyMenu;
import Source.Menu.StartMenu;
import Source.Structure.Actions.Factory.DNAActionFactory;
import Source.Structure.Actions.Factory.RNAActionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddMenuTest {
    private AddMenu addMenu = new AddMenu();

    @Test
    void getNextMenu() {
//        case "1" -> new AddAcidMenu(new RNAActionFactory());
        assertEquals(addMenu.getNextMenu("1").getClass(), AddAcidMenu.class);

//        case "2" -> new AddAcidMenu(new DNAActionFactory());
        assertEquals(addMenu.getNextMenu("2").getClass(), AddAcidMenu.class);

//        case "3" -> new AddGeneMenu();
        assertEquals(addMenu.getNextMenu("3").getClass(), AddGeneMenu.class);

//        case "4" -> new AddChainMenu();
        assertEquals(addMenu.getNextMenu("4").getClass(), AddChainMenu.class);

//        default -> throw new RuntimeException();
        try {
            addMenu.getNextMenu("5");
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
        }
    }
}