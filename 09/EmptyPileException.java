package week09;

import java.util.NoSuchElementException;

/**
 * EmptyPileException
 * @author Hugo Ayre and Elijah Zolduoarrati.
 */
public class EmptyPileException extends NoSuchElementException {
    /**Long of the serialVerisonUID. */
    private static final long serialVersionUID = 1L;

    public EmptyPileException(String msg) {
        super(msg);
    }
	
}
