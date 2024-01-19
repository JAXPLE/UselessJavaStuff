package uselessjava.tuple;

import uselessjava.UObject;
import uselessjava.exception.TupleDoesNotContainElementException;

/**
 * The base interface for tuples.
 *
 * @param <T> The type of element of which to contain
 */
public interface Tuple<T extends UObject> extends UObject {
    /**
     * Returns the size of this tuple. The size of a tuple is determined by the number of elements contained
     * within this tuple. If this tuple allows the containment of {@code null} values, each {@code null} value
     * will be counted as an independent element. Similarly, two entries of the same instance will be counted
     * separately. Furthermore, {@link Object#equals(Object) different instances with equality} will also
     * be counted separately. This will accurately represent the size of this tuple, regardless of whether
     * {@code null} values or several entries of the same objects are present.
     *
     * @return The size of this tuple
     */
    int size();

    /**
     * Performs a containment check on this tuple of the provided {@link UObject object} {@code obj}.
     * @param obj
     * @return
     * @throws TupleDoesNotContainElementException
     */
    boolean contains(UObject obj) throws TupleDoesNotContainElementException;
}
