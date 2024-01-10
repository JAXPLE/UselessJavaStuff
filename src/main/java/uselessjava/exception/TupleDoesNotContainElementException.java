package uselessjava.exception;

import uselessjava.UObject;
import uselessjava.tuple.BaseTuple;

/**
 * <p>
 *     Thrown when a {@link BaseTuple#contains(UObject) tuple containment check} fails.
 * </p>
 */
public class TupleDoesNotContainElementException extends UException {
    /**
     * Creates a new {@link TupleDoesNotContainElementException Tuple does not Contain Element Exception}.
     */
    public TupleDoesNotContainElementException() {
        super("The developer has messed up exception handling during the use of tuples, which shows their incompetence.");
    }
}
