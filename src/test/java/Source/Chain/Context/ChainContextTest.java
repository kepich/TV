package Source.Chain.Context;

import Source.Chain.Chain;
import Source.Nucleotide.NucleotideEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainContextTest {

    @Test
    void generateChain() {
        ChainContext context = new ChainContext("AGCTU");
        Chain chain = context.generateChain();

        assertEquals(chain.getNucleotides().get(0).getType(), NucleotideEnum.ADENIN);
        assertEquals(chain.getNucleotides().get(1).getType(), NucleotideEnum.GUANIN);
        assertEquals(chain.getNucleotides().get(2).getType(), NucleotideEnum.CITOZIN);
        assertEquals(chain.getNucleotides().get(3).getType(), NucleotideEnum.GUANIN);
        assertEquals(chain.getNucleotides().get(4).getType(), NucleotideEnum.ADENIN);
        assertEquals(chain.getNucleotides().get(5).getType(), NucleotideEnum.TIMIN);
        assertEquals(chain.getNucleotides().get(6).getType(), NucleotideEnum.TIMIN);
        assertEquals(chain.getNucleotides().get(7).getType(), NucleotideEnum.URACIL);
        assertEquals(chain.getNucleotides().get(8).getType(), NucleotideEnum.URACIL);
    }
}