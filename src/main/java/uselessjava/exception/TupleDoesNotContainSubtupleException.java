package uselessjava.exception;

import uselessjava.tuple.Tuple;

/**
 * <p>
 * Thrown when a {@link Tuple#containsAll(Tuple)} tuple containment check} fails.
 * </p>
 */
public class TupleDoesNotContainSubtupleException extends UException {
    /**
     * Creates a new {@link TupleDoesNotContainSubtupleException Tuple does not Contain Subtuple Exception}.
     */
    public TupleDoesNotContainSubtupleException() {
        super("The developer has messed up exception handling during the use of tuples, which shows their incompetence.");
    }
}
