package week07;

import java.util.*;
import java.io.*;
/**
 * An application that produces a random sequence of letters.
 *
 *@author hugo
 */

public class FrequencyGenerator implements WordGenerator {
    /** Random source used to generate words. */
    private Random random;
    /** Double array used to store the file. */
    private double[] w = new double['z'-'a'+1]; 

    /**
     *  Constructs a basic random word generator which uses the given
     *  random source.
     *  Reads the text from the file and adds it to an array.
     * @param r a source of randomness used when generating words.
     */
    public FrequencyGenerator(Random r) {
        random = r;
        File file = new File("letter-frequencies.txt");

        try {
            Scanner sc = new Scanner(file);
            for (int i = 0; sc.hasNextDouble(); i++){
                w[i] = sc.nextDouble();
            }
            sc.close();

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

        for(int i = 0; i < n; i++) {
            char c = (char) ('a' + chooseIndex());
            result.append(c);
        }

        return result.toString();
    }
    /**
     * Return a random letter.
     * @return a random letter.
     */
    public double chooseIndex(){
        int i = 0;
        double r = random.nextDouble();

        while (r>w[i]){
            r = r -w[i];
            i++;
        }
        return i;
    }

}
