import edu.duke.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Write a description of Points here.
 * 
 * @author Hozaifa Owaisi 
 * @version 1.0
 */
public class Find_Gene {
    public String FindGene(String dna) {
        int start_gene = dna.indexOf("ATG");
        int end_gene = dna.indexOf("TAA",start_gene+3);
        int multiple = (start_gene-end_gene)%3;
        String gene_sequense = dna.substring(start_gene,end_gene+3);
        if (start_gene == -1) {
            return "NO GENES";
        }
        if (multiple!= 0) {
            return "NO GENES";
        }
        if (end_gene == -1) {
            return "NO GENES";
        }
        return gene_sequense;
    }
    
    public void testFind() {
    
        FileResource dna_file = new FileResource("ak.txt");
        String dna = dna_file.asString();
        Find_Gene gene = new Find_Gene();
        String result_gene = gene.FindGene(dna);
        System.out.println("DNA: " + dna);
        System.out.println("GENE: "+result_gene);
    }
}
