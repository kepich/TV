package Source.Chain.Context;

import Source.Chain.Chain;
import Source.Nucleotide.NucleotideEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChainAddingNucleotideSeqTest {

    @Test
    void addNucleotide() {
        ChainState chainAddingNucleotideSeq = new ChainAddingNucleotideSeq("AGCTU");
        Chain chain = new Chain(new ArrayList<>());

        chainAddingNucleotideSeq = chainAddingNucleotideSeq.addNucleotide(chain);
        assertEquals(chain.getNucleotides().get(0).getType(), NucleotideEnum.ADENIN);

        chainAddingNucleotideSeq = chainAddingNucleotideSeq.addNucleotide(chain);
        assertEquals(chain.getNucleotides().get(1).getType(), NucleotideEnum.GUANIN);
        assertEquals(chain.getNucleotides().get(2).getType(), NucleotideEnum.CITOZIN);

        chainAddingNucleotideSeq = chainAddingNucleotideSeq.addNucleotide(chain);
        assertEquals(chain.getNucleotides().get(3).getType(), NucleotideEnum.GUANIN);
        assertEquals(chain.getNucleotides().get(4).getType(), NucleotideEnum.ADENIN);

        chainAddingNucleotideSeq = chainAddingNucleotideSeq.addNucleotide(chain);
        assertEquals(chain.getNucleotides().get(5).getType(), NucleotideEnum.TIMIN);
        assertEquals(chain.getNucleotides().get(6).getType(), NucleotideEnum.TIMIN);

        chainAddingNucleotideSeq = chainAddingNucleotideSeq.addNucleotide(chain);
        assertEquals(chain.getNucleotides().get(7).getType(), NucleotideEnum.URACIL);
        assertEquals(chain.getNucleotides().get(8).getType(), NucleotideEnum.URACIL);

        chainAddingNucleotideSeq = chainAddingNucleotideSeq.addNucleotide(chain);
        assertEquals(chainAddingNucleotideSeq.getClass(), ChainEndNucleotideSeq.class);
    }
}