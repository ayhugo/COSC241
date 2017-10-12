package week05;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    // public static void main(String[] args) {
    // int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
    // System.out.println(TableauApp.toString(valid));
        // System.out.println(TableauApp.rowLengthDecrease(valid));
    // System.out.println(TableauApp.rowValuesIncrease(valid));
    //  System.out.println(TableauApp.columnValuesIncrease(valid));
    //    System.out.println(TableauApp.isSetOf1toN(valid));
        
    // }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if (rowLengthsDecrease(t) && rowValuesIncrease(t) &&
            columnValuesIncrease(t) && isSetOf1toN(t)){
            return true;
        }
        return false;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    /**
     *  Returns a description of whether the length of the rows decrease
     *  from the preceding row.
     * @param t a two-dimentional array which represents a tableau.
     * @return a boolean representation for a decrease in row length.
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        int rowLength = t[0].length;
        for (int i = 0; i < t.length; i++){
            if (t[i].length >  rowLength){
                return false;
            }
            rowLength = t[i].length; 
        }
        return true; 
    }
    /**
     *  Returns a description of whether the values of the rows increase
     *  from left to right.
     * @param t a two-dimentional array which represents a tableau.
     * @return a boolean representation for an increase along a row.
     */
    public static boolean rowValuesIncrease(int[][] t){
        int rowValues = t[0][0];
        for (int row = 0; row < t.length; row++){
            for (int col = 0; col < t[row].length; col++){
                if (rowValues > t[row][col]){
                    return false;
                }
                rowValues = t[row][col];
            }
            rowValues = t[row][0];
        }
        return true;
    }
    /**
     *  Returns a description of whether the values of the columns
     *  increase from top to bottom.
     * @param t a two-dimentional array which represents a tableau.
     * @return a boolean representation for an increase down
     * a column.
     */
    public static boolean columnValuesIncrease(int[][] t){
        for (int col = 0; col < t[0].length; col ++){
            for (int row = 0; row < t.length-1; row++){
                if (col < t[row].length && col<t[row+1].length){
                    if (t[row+1][col] < t[row][col]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     *  Returns a description of whether set of ints used includes
     *  1 to the length of the array.
     * @param t a two-dimentional array which represents a tableau.
     * @return a boolean representation for the set of ints going
     * from 1 to the length of the array. 
     */
    public static boolean isSetOf1toN(int[][] t){
        int cellCount = 0;
        int n = 0;
        for (int row=0; row<t.length; row++){
            for (int col = 0; col < t[row].length; col++){
                cellCount ++;
                if (t[row][col] > n){
                    n = t[row][col];
                }else if (t[row][col] == n){
                    return false;
                }
            }
        }
        return n == cellCount;
    }
}
