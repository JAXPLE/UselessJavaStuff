package uselessjava.exception;

import uselessjava.tuple.Tuple;

/**
 * <p>
 * Thrown when an unreachable element of a {@link Tuple tuple} is reached, exceeding
 * the bounds of the karmic nature of {@link Tuple tuple indexing}, simply put:
 * Thrown when a {@link Tuple tuple}'s index is out of bounds.
 * </p>
 */
public class TupleIndexOutOfBoundsException extends UException {
    /**
     * Creates a new {@link TupleIndexOutOfBoundsException Tuple Index out of Bounds Exception}.
     */
    public TupleIndexOutOfBoundsException() {
        super("The developer has messed up a modulo operator. They should learn some basic math.");
    }
}
