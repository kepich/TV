package Source.Menu.Show;

import Source.Menu.StartMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowMenuTest {
    private ShowMenu showMenu = new ShowMenu();

    @Test
    void getNextMenu() {
        assertEquals(showMenu.getNextMenu("1").getClass(), StartMenu.class);
        assertEquals(showMenu.getNextMenu("2").getClass(), StartMenu.class);
    }
}