package Source.Structure.RNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Structure.Acid.Acid;
import Source.Structure.Actions.Mutate.Impl.DefaultMutate;
import Source.Structure.Actions.Mutate.Impl.EmptyMutate;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Impl.DefaultReplicate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Impl.EmptySplit;
import Source.Structure.Actions.Split.Splitter.RNASplitter;
import Source.Structure.Actions.Split.Splitter.Splitter;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class RNA extends Acid implements Cloneable {
    public RNA(ArrayList<Gene> genes, Replicate replicate, Mutate mutate, Splitter splitter) throws UnexpectedException {
        super(
                replicate,
                mutate,
                splitter,
                MyLoggerFactory.getLogger(RNA.class.getName())
        );
        this.validateGenes(genes);

        this.genes = genes;
        this.logger.info("Created " + this.toString());
    }

    public RNA(ArrayList<Gene> genes) throws UnexpectedException {
        super(
                new DefaultReplicate(),
                new EmptyMutate(),
                new RNASplitter(new EmptySplit()),
                MyLoggerFactory.getLogger(RNA.class.getName())
        );
        this.validateGenes(genes);

        this.genes = genes;
        this.logger.info("Created " + this.toString());
    }

    protected void validateGenes(ArrayList<Gene> genes) throws UnexpectedException {
        for (Gene gene : genes) {
            for (Nucleotide nucleotide : gene.getChain().getNucleotides()) {
                if (nucleotide.getType() == NucleotideEnum.TIMIN)
                    throw new UnexpectedException("TIMIN is not available for RNA");
            }
        }
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        if (position < this.getGenes().size()) {
            this.genes.set(position, gene);
            this.logger.info("Set gene " + gene.toString() + " on position " + position.toString());
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public Gene getGene(Integer position) {
        if (position < this.getGenes().size()) {
            Gene result = this.genes.get(position);
            this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
            return result;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void addGene(Gene gene) {
        this.genes.add(gene);
        this.logger.info("Add gene " + gene.toString());
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.genes;
    }

    @Override
    public RNA mutate() throws UnexpectedException {
        this.logger.info("Mutation failed");
        return new RNA(this.actionPack.mutate(this.getGenes(), 0.01f, Nucleotide.getRNANucleotides()));
    }

    @Override
    public RNA replicate() throws UnexpectedException {
        logger.info("Replicate RNA " + this.toString());
        return new RNA(actionPack.replicate(this.getGenes(), 0.05f, Nucleotide.getRNANucleotides()));
    }

    public Chain split() {
        Chain result = actionPack.split(this.getGenes());
        logger.info("Split RNA " + this.toString() + " to chain " + result);
        return result;
    }

    @Override
    public String toString() {
        return "RNA {" +
                "genes=" + genes +
                '}';
    }
}
