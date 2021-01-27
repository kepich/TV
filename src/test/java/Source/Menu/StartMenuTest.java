package Source.Menu;

import Source.Menu.Add.AddMenu;
import Source.Menu.Modify.ModifyMenu;
import Source.Menu.Show.ShowMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StartMenuTest {
    private StartMenu startMenu = new StartMenu();

    @Test
    public void testGetNextMenu() {
        //case "1" -> new AddMenu();
        assertEquals(startMenu.getNextMenu("1").getClass(), AddMenu.class);

        //case "2" -> new ShowMenu();
        assertEquals(startMenu.getNextMenu("2").getClass(), ShowMenu.class);

        //case "3" -> new ModifyMenu();
        assertEquals(startMenu.getNextMenu("3").getClass(), ModifyMenu.class);

        //case "4" -> null;
        assertNull(startMenu.getNextMenu("4"));

        //default -> throw new RuntimeException();
        try {
            startMenu.getNextMenu("5");
        } catch (Exception e) {
            assertEquals(e.getClass(), RuntimeException.class);
        }
    }
}