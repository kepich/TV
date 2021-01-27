package Source.Nucleotide;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NucleotideTest {

    @Test
    void getDNANucleotides() {
        Nucleotide[] nucleotides = Nucleotide.getRNANucleotides();
        assertEquals(nucleotides[0].getType(), NucleotideEnum.ADENIN);
        assertEquals(nucleotides[1].getType(), NucleotideEnum.GUANIN);
        assertEquals(nucleotides[2].getType(), NucleotideEnum.CITOZIN);
        assertEquals(nucleotides[3].getType(), NucleotideEnum.URACIL);
    }

    @Test
    void getRNANucleotides() {
        Nucleotide[] nucleotides = Nucleotide.getDNANucleotides();
        assertEquals(nucleotides[0].getType(), NucleotideEnum.ADENIN);
        assertEquals(nucleotides[1].getType(), NucleotideEnum.GUANIN);
        assertEquals(nucleotides[2].getType(), NucleotideEnum.CITOZIN);
        assertEquals(nucleotides[3].getType(), NucleotideEnum.TIMIN);
    }
}