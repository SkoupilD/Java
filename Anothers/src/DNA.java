public class DNA{
    public void isProtein(String dna){
        int start = dna.indexOf("ATG");
        int stop = dna.indexOf("TGA");
        if (start == 0 && stop != -1 && (stop - start) % 3 == 0){
            String protein = dna.substring(start, stop + 3);
            System.out.println("Protein: " + protein);
        } else {
            System.out.println("No protein");
        }
    }
    public static void main(String[] args){
        String dna1 = "ATGCGATACGCTTGA";
        String dna2 = "ATGCGATACGTGA";
        String dna3 = "ATTAATATGTACTGA";
        DNA dna = new DNA();
        dna.isProtein(dna1);
        dna.isProtein(dna2);
        dna.isProtein(dna3);
    }
}