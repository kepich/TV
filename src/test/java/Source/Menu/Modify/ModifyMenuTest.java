package Source.Menu.Modify;

import Source.Menu.Add.AddMenu;
import Source.Menu.StartMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyMenuTest {
    private ModifyMenu modifyMenu = new ModifyMenu();

    @Test
    void getNextMenu() {
        //case "1" -> new AcidModifyMenu();
        assertEquals(modifyMenu.getNextMenu("1").getClass(), AcidModifyMenu.class);

        //case "2" -> new GeneModifyMenu();
        assertEquals(modifyMenu.getNextMenu("2").getClass(), GeneModifyMenu.class);

        //case "3" -> new ChainModifyMenu();
        assertEquals(modifyMenu.getNextMenu("3").getClass(), ChainModifyMenu.class);

        //case "4" -> new StartMenu();
        assertEquals(modifyMenu.getNextMenu("4").getClass(), StartMenu.class);

        //default -> throw new RuntimeException();
        try {
            modifyMenu.getNextMenu("5");
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
        }
    }
}