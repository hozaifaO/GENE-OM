import edu.duke.*;
/**
 * Write a description of Points here.
 * 
 * @author Hozaifa Owaisi 
 * @version 1.0
 */
public class Find_Gene {
    public String FindGene(String dna) {
        int start_gene = dna.indexOf("ATG");
        int curr_gene = dna.indexOf("TAA",start_gene+3);
        int multiple = (start_gene-curr_gene)%3;
        if (start_gene == -1) {
            return "NO GENES";
        }
        
        while (curr_gene != -1) {
            if ((curr_gene-start_gene)%3 == 0) {
             return dna.substring(start_gene,curr_gene+3);
            }
            else {
              curr_gene = dna.indexOf("TAA",curr_gene+1);
            }
        }
        return "NO GENE";
    }
    
    public void testFind() {
    
        FileResource dna_file = new FileResource("TEST.txt");
        String dna = dna_file.asString();
        Find_Gene gene = new Find_Gene();
        String result_gene = gene.FindGene(dna);
        System.out.println("DNA: " + dna);
        System.out.println("GENE: "+result_gene);
    }
}
