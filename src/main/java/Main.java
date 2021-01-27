import Source.Chain.Chain;
import Source.Chain.Context.ChainAddingNucleotideSeq;
import Source.Chain.Context.ChainContext;
import Source.Chain.Context.ChainEndNucleotideSeq;
import Source.Chain.Context.ChainStartNucleotideSeq;
import Source.Menu.AppState;
import Source.Menu.StartMenu;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.NucleotideManager;

import java.rmi.UnexpectedException;

public class Main {
    private MyLogger logger = MyLoggerFactory.getLogger(Main.class.getName());

    public Main() {
    }

    public static void main(String[] args) {
        Main app = new Main();

        try {
            app.run();
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

    private void run() throws UnexpectedException {
        logger.info("Started");

        MyLoggerFactory.getLogger(ChainContext.class.getName()).disable();
        MyLoggerFactory.getLogger(NucleotideManager.class.getName()).disable();
        MyLoggerFactory.getLogger(MyLoggerFactory.class.getName()).disable();
        MyLoggerFactory.getLogger(ChainEndNucleotideSeq.class.getName()).disable();
        MyLoggerFactory.getLogger(ChainAddingNucleotideSeq.class.getName()).disable();
        MyLoggerFactory.getLogger(ChainStartNucleotideSeq.class.getName()).disable();
        MyLoggerFactory.getLogger(Chain.class.getName()).disable();

        AppState menu = new StartMenu();

        while (menu != null){
            menu = menu.perform();
        }
    }

}
