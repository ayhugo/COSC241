package week09;

import java.util.List;
/**
 * Exampile interface that calls the related methods.
 * @author Hugo Ayre and Elijah Zolduoarrati.
 */
public interface ExamPile {
    /**
     * Initialize the pile of exams to consist of the contents of the list perovided.
     * The example elements of the list represents the exams
     * in order from top to bottom of the pile.
     * The internal representation of the pile need not be as a list.
     * @param loading items into the list. 
     */
    public void load(List<Integer> items);


    /**
     * Returns the value at the top of the pile.
     * @return the value at the top of the pile.
     */
    public int peek();

    /**
     * Returns the given value from the top section of the pile, as specified by depth , and removes it from the pile.
     * Returns -1 if the value is not found.
     * @param depth specifies how deep to look within the pile.
     * @param value specifies which value to look for.
     * @return the given value parameter if found in the pile.
     */
    public int mark(int depth, int value);

    /**
     * Moves count values from the top of the pile to the bottom of the pile.
     * @param count specifies at which position in the pile.
     */
    public void delay(int count);
}
