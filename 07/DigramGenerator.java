package week07;

import java.util.*;
import java.io.*;
/**
 * An application that produces a random continuation of letters.
 *
 *@author hugo
 */
public class DigramGenerator implements WordGenerator {
    /** Random source used to generate words. */
    private Random random;
    /** String  used to store the file. */
    private String s = "";
    /** Double array used to store the file. */
    private String[] w = new String['z'-'a'+1];

    /**
     *  Constructs a basic random word generator which uses the given
     *  random source.
     *  Reads the text from the file and adds it to an array.
     * @param r a source of randomness used when generating words.
     */
    public DigramGenerator(Random r) {
        random = r;
        File fileOne = new File("first-letters.txt");
        File fileTwo = new File("continuations.txt");

        try {
            Scanner sc = new Scanner(fileOne);
            for (int i = 0; sc.hasNextLine(); i++){
                s+= sc.nextLine();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            Scanner scan = new Scanner(fileTwo);
            for (int i = 0; scan.hasNextLine(); i++){
                w[i] = scan.nextLine();
            }
            scan.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    /**
     *  Return a random word of length n.
     *
     * @param n the required length of the word.
     *
     * @return a random word of length n.
     */    
    public String nextWord(int n) {
        final int alphabetLength = 26;
        StringBuilder result = new StringBuilder();


        char prevLetter = s.charAt(random.nextInt(s.length()));
        result.append(prevLetter);
        
        for(int i = 1; i < n; i++) {
            int index =  prevLetter-'a';
            char newLetter = w[index].charAt(random.nextInt(w[index].length()));
            result.append(newLetter);
            prevLetter = newLetter;
        }

        return result.toString();
    }

 

}
