package Source.Menu;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Menu.Add.AddMenu;
import Source.Menu.Modify.ModifyMenu;
import Source.Menu.Show.ShowMenu;
import Source.Structure.Acid.Acid;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class AppState {
    protected static ArrayList<Chain> chains = new ArrayList<>();
    protected static ArrayList<Gene> genes = new ArrayList<>();
    protected static ArrayList<Acid> acids = new ArrayList<>();
    protected static Scanner sc = new Scanner(System.in);
    protected static String tempMenu;

    public AppState perform() throws UnexpectedException {
        printMenu();

        AppState result;

        while (true){
            tempMenu = sc.nextLine();
            try {
                result = getNextMenu(tempMenu);
            } catch (RuntimeException e){
                System.out.println("Incorrect input! Try again!");
                continue;
            }
            break;
        }

        return result;
    };

    protected static String getNucleotidesString(){
        System.out.println("Enter nucleotides:");
        return sc.nextLine();
    }

    protected void printAcids(){
        System.out.println("Acids:");
        for(Acid acid: acids){
            System.out.println("\t" + acids.indexOf(acid) + ". " + acid.toString());
        }
        System.out.println("");
    }

    protected void printGenes(){
        System.out.println("Genes:");
        for(Gene gene: genes){
            System.out.println("\t" + genes.indexOf(gene) + ". " + gene.toString());
        }
        System.out.println("");
    }

    protected void printChains(){
        System.out.println("Chains:");
        for(Chain chain: chains){
            System.out.println("\t" + chains.indexOf(chain) + ". " + chain.toString());
        }
        System.out.println("");
    }

    protected abstract void printMenu();

    protected abstract AppState getNextMenu(String nextMenuNumber);
}
