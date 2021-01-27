package Source.Structure.RNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Structure.DNA.DNA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RNATest {
    private RNA rna;
    private Chain chain;
    private Gene gene;
    private ArrayList<Gene> genes;

    @BeforeEach
    void init(){
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();

        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.GUANIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.CITOZIN));

        this.chain = new Chain(nucleotides);
        this.gene = new Gene(this.chain);
        this.genes = new ArrayList<>();
        this.genes.add(this.gene);

        try {
            this.rna = new RNA(genes);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void setGene() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();

        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.GUANIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.CITOZIN));

        Chain chainNew = new Chain(nucleotides);
        Gene geneNew = new Gene(chainNew);
        this.rna.setGene(geneNew, 0);

        assertEquals(this.rna.getGenes().get(0), geneNew);
    }

    @Test
    void getGene() {
        assertEquals(this.rna.getGene(0), this.gene);
    }

    @Test
    void addGene() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();

        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.GUANIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.CITOZIN));

        Chain chainNew = new Chain(nucleotides);
        Gene geneNew = new Gene(chainNew);
        this.rna.addGene(geneNew);

        assertEquals(this.rna.getGenes().get(0), this.gene);
        assertEquals(this.rna.getGenes().get(1), geneNew);
    }
}