package Source.Chain;

import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChainTest {

    @Test
    void addNucleotide() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();
        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));

        Chain chain = new Chain(nucleotides);
        Nucleotide nucleotide = new Nucleotide(NucleotideEnum.GUANIN);
        chain.addNucleotide(nucleotide);
        assertEquals(nucleotide, chain.getNucleotides().get(1));
    }

    @Test
    void setNucleotide() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();
        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));

        Chain chain = new Chain(nucleotides);
        Nucleotide nucleotide = new Nucleotide(NucleotideEnum.GUANIN);
        chain.setNucleotide(0, nucleotide);
        assertEquals(nucleotide, chain.getNucleotides().get(0));
    }

    @Test
    void getNucleotide() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();
        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));

        Nucleotide nucleotide = new Nucleotide(NucleotideEnum.GUANIN);
        nucleotides.add(nucleotide);

        Chain chain = new Chain(nucleotides);
        assertEquals(nucleotide, chain.getNucleotide(1));
    }

    @Test
    void getNucleotides() {
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();
        nucleotides.add(new Nucleotide(NucleotideEnum.ADENIN));

        Chain chain = new Chain(nucleotides);
        assertEquals(nucleotides, chain.getNucleotides());
    }
}