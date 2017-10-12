package week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * An application that orders the marked grades in an exam pile.
 *@author Hugo Ayre and Elijah Zolduoarrati.
 */
public class EP implements ExamPile {
    /**Creates a linked list of the exam piles. */
    private LinkedList<Integer> examPiles;

    /** Sets the current depth. */
    private int depth = 1;
	
    /**
     * Reads from the input file and sends the result to sortingSteps().
     * @param args command line arguments are used. 
     */
    public static void main(String[] args) {
		 

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            List<Integer> list = new ArrayList<Integer>();
            EP ep = new EP();
                 
            String nextLine = sc.nextLine();
            String[] values = nextLine.split(" ");
               
            for(String val : values) {
                list.add(Integer.parseInt(val));
            }
            if(args.length > 0){
                int argsInt = Integer.parseInt(args[0]);
                ep.setDepth(argsInt);
            }
           
            ep.load(list);
            System.out.println(ep.sortingSteps());
        }

       
    }
	
    /**
     * Initialize the pile of exams to consist of the contents of the list perovided.
     * The example elements of the list represents the exams in order from top to bottom of the pile.
     * The internal representation of the pile need not be as a list.
     * @param loading items into the list. 
     */
    @Override
    public void load(List<Integer> items) {
        examPiles = new LinkedList<Integer>();
        examPiles.addAll(items);
    }

    /**
     * Returns a number of exams remaining in the pile.
     * @return an int that is number of exams remaining in the pile.
     */
    public int size() {
        if (examPiles.isEmpty()) {
            return 0;
        } else {
            return examPiles.size();
        }
    }
	
    /**
     * Returns the value at the top of the pile.
     * @return the value at the top of the pile.
     */
    @Override
    public int peek() {
        try {
            return examPiles.getFirst();
        } catch (EmptyPileException e) {
            throw new EmptyPileException("The exam pile is an empty");
        }
    }
	
    /**
     * Returns the given value from the top section of the pile, as specified by depth , and removes it from the pile.
     * Returns -1 if the value is not found.
     * @param depth specifies how deep to look within the pile.
     * @param value specifies which value to look for.
     * @return the given value parameter if found in the pile.
     */
    @Override
    public int mark(int depth, int value) {
        try {
            int currentNode = peek();
            for (int index = 1; index <= depth; index++) {
                if (currentNode == value) {
                    examPiles.remove(index - 1);
                    return value;
                } else {
                    currentNode = examPiles.get(index);
                }
            }
            return -1;
        } catch (EmptyPileException e) {
            throw new EmptyPileException("The exam pile is an empty");
        }
    }
	
    /**
     * Moves count values from the top of the pile to the bottom of the pile.
     * @param count specifies at which position in the pile.
     */
    @Override
    public void delay(int count) {
        try {
            int examToBottom = 1;
            while (examToBottom <= count) {
                int temp = examPiles.getFirst();
                examPiles.add(temp);
                examPiles.remove(examPiles.getFirst());
                examToBottom++;
            }
        } catch (EmptyPileException e) {
            throw new EmptyPileException("The exam pile is an empty");
        }
    }
	
    /**
     * Depth setter method.
     * @param The depth within the file.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
	
    /**
     * Every successful mark,an 'M' is added to a string, and every failed mark
     * a 'D' is added to the string. The string is then printed and returned.
     * 
     * @return a string that has every successful and failed mark. Repesented by 'M' and 'D'.
     */
    public String sortingSteps() {
        String marks = "";
        int i = 0;
        while (size() != 0) {
            if (mark(depth, i) == i) {
                marks += "M";
                i++;
            } else {
                delay(depth);
                marks += "D";
            }
        }
        return marks.toString();
    }


}
// end class
