package week02;
import java.util.Random;
/** counts the number of times a coin is flipped.
    @author Hugo
*/
public class Coins{
    /** boolean for heads.
     */
    public static final boolean HEADS = true;
    /** boolean for tails.
     */
    public static final boolean TAILS = false;
    /** boolean array for coins.
     */
    private boolean[] coins;

    /**
     *this is a comment asdkjdahjda. 
     *@param coins boolean
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    /**
     * prints countHeads, tostring and countRuns.
     * @param args Description of args.
     */
    public static void main(String[] args) {
        // int number = 6;
        // boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        // Coins c = new Coins(number);
        // System.out.println(c.countHeads());
        // System.out.println(c.toString());
        // System.out.println(c.countRuns());
        
    }
    
    /**
     * Returns an int which is the number of runs in this sequence of coins.
     * @return run
     */
    public int  countRuns(){
        int run = 1;
        for (int i = 1; i<coins.length; i++){
            if (coins[i] != coins[i-1]){
                run++;
            }
        }
        return run;     
    }

    /**
     * structs a Coins object  consisting  of  a  series  of length coins – the
     * value of each coin should be determined by a random coin toss.
     * @param lengths 
     */
    public Coins (int lengths){
        boolean toss[] = new boolean[lengths];
        Random random = new Random();
        for (int i = 0; i<toss.length; i++){
            toss[i]=random.nextBoolean();
        }
        coins=toss;
    }

    /**
     * Creates a Coins object from a String consisting entirely of the
     * characters H and T.
     * @param c 
     */
    public Coins (String c){
        this.coins = new boolean[c.length()];
        for (int i = 0; i<coins.length; i++){
            if (c.charAt(i) == 'H'){
                this.coins[i] = HEADS;  
            } else {
                this.coins[i] = TAILS;
            }
        }
    }

    /**
     * method that returns an int which is the number of
     * occurrences of “heads” in the coin tosses.
     * @return h
     */
    public int  countHeads(){
        int h = 0;
        for(int i=0; i<coins.length; i++){
            if (coins[i]==HEADS){
                h++;
            }
        }
        
        return h;
    }
    /** A method that returns a String representation of the coin
     *    tosses, using H to represent heads and T to represent tails.
     * @return s
     */

    public String toString(){
        String s = "";
        for (int i=0; i<coins.length; i++){
        
            if (coins[i]==HEADS){
                s+="H";
            }else {
                s+="T";
            }
        }
        return s;
    }
                            

}

