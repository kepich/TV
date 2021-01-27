package Source.Structure.DNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DNATest {
    private DNA dna;
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
            this.dna = new DNA(genes);
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
        this.dna.setGene(geneNew, 0);

        assertEquals(this.dna.getGenes().get(0), geneNew);
    }

    @Test
    void getGene() {
        assertEquals(this.dna.getGene(0), this.gene);
    }

    @Test
    void addGene() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();

        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.GUANIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.CITOZIN));

        Chain chainNew = new Chain(nucleotides);
        Gene geneNew = new Gene(chainNew);
        this.dna.addGene(geneNew);

        assertEquals(this.dna.getGenes().get(0), this.gene);
        assertEquals(this.dna.getGenes().get(1), geneNew);
    }
}