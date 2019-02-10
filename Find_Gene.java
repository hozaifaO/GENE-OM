import edu.duke.*;
/**
 * Write a description of Points here.
 * 
 * @author Hozaifa Owaisi 
 * @version 1.0
 */
public class Find_Gene{
    public String FindGene(String dna) {
        int start_gene = dna.indexOf("ATG");
        if (start_gene == -1) {
            return "NO GENES";
        }
        int taa_Index = firstStopCodon(dna,start_gene,"TAA");
        int tag_Index = firstStopCodon(dna,start_gene,"TAG");
        int tga_Index = firstStopCodon(dna,start_gene,"TGA");
        int min_index = 0;
        //int temp_min = Math.min(taa_Index,tag_Index);
        //int min_index = Math.min(temp_min,tga_Index);
        if(taa_Index == -1 || tga_Index != -1 && tag_Index < taa_Index) {
            min_index = tga_Index;
        }
        else {
            min_index = taa_Index;
        }
        
        if(min_index == -1 || tga_Index != -1 && tga_Index < min_index) {
            min_index = tag_Index;
        } 
        
        if(min_index == -1) {
            return "NO GENES";
        }
        return dna.substring(start_gene,min_index+3);
    }
    
    public int firstStopCodon(String dna_sur, int startIndex, String StopCodon) {
        int curr_Index = dna_sur.indexOf(StopCodon,startIndex+3);
        while(curr_Index != -1) {
            if ((curr_Index - startIndex)%3 == 0) {
                return curr_Index;
            }
            else {
                curr_Index = dna_sur.indexOf(StopCodon,curr_Index+1);
            }
        }
        return -1;
    }
    
    public static void main(String args) {
    
        FileResource dna_file = new FileResource(args);
        System.out.println(args);
        String dna = dna_file.asString();
        Find_Gene gene = new Find_Gene();
        String result_gene = gene.FindGene(dna);
        System.out.println("DNA: " + dna);
        System.out.println("GENE: "+result_gene);
    }
}
