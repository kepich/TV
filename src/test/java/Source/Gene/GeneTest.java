package Source.Gene;

import Source.Chain.Chain;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneTest {
    private Gene gene;
    private Chain chain;

    @BeforeEach
    public void init() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();
        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.GUANIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.CITOZIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.TIMIN));
        nucleotides.add(new Nucleotide(NucleotideEnum.URACIL));
        this.chain = new Chain(nucleotides);
        this.gene = new Gene(this.chain);
    }

    @Test
    void getChain() {
        assertEquals(chain, gene.getChain());
    }

    @Test
    void setChain() {
        ArrayList<Nucleotide> newNucleotides = new ArrayList<>();
        newNucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));
        Chain newChain = new Chain(newNucleotides);
        this.gene.setChain(newChain);
        assertEquals(newChain, gene.getChain());
    }

    @Test
    void split() {
        List<Nucleotide> nucleotides = this.gene.split();
        assertEquals(nucleotides.get(0).getType(), NucleotideEnum.ADENIN);
        assertEquals(nucleotides.get(1).getType(), NucleotideEnum.GUANIN);
        assertEquals(nucleotides.get(2).getType(), NucleotideEnum.CITOZIN);
        assertEquals(nucleotides.get(3).getType(), NucleotideEnum.TIMIN);
        assertEquals(nucleotides.get(4).getType(), NucleotideEnum.URACIL);
    }
}