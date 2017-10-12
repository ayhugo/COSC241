package week01;
import java.util.Scanner;

/** counts the number of lines and words on an input from user.
    @author Hugo
*/
public class Counter {

    /**
     * counts the number of lines and words on an input from user.
     * @param args Description of args.
     */
    public static void main(String[]args){
        int lines = 0;
        int words = 0;

        Scanner reader = new Scanner(System.in);
        
       
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            
            Scanner input = new Scanner(line);

            
            while (input.hasNext()){
               
                input.next();
                words++;
            }
            lines++;
        }
        
      

        System.out.println("lines: "+ lines);
        System.out.println("words: "+ words);

    }
}
