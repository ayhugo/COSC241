package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Hugo Ayre
 */
public class Tower{

    /** The top block. */
    private char top;
    
    /** The rest of the tower. */
    private Tower rest;

    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }
    
    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }
        
    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }
    /**
     *returns the number of blocks in the tower.
     *@return an int equal to the height.
     */
    public int height(){
        int n = 0;
        if (this.isEmpty()){
            return n;
        } else {
            return n+= ( 1 + this.rest.height());
        }
    }
    /**
     *returns an int equal to the number of blocks equal in to c.
     *@return int equal to the number of blocks equal to c.
     *@param c is a char
     */
    public int count(char c){
        if (isEmpty()){
            return 0;
        }else if (this.top == c){
            return rest.count(c)+1;
        }else{
            return rest.count(c);
        }
    
    }

    // public static void main(String[]args){
    //    Tower g = new Tower();
    //    Tower g1 = g.add('a');
    //    Tower g2 = g1.add('b');
    //    Tower g3 = g2.add('a');
    //    System.out.println(g3.height());
    //    System.out.println(g3.count('a'));
    //   }

}
