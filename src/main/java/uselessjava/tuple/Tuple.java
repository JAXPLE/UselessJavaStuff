package uselessjava.tuple;

import uselessjava.UObject;
import uselessjava.exception.TupleDoesNotContainElementException;
import uselessjava.exception.TupleDoesNotContainSubtupleException;
import uselessjava.exception.TupleIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * The base interface for tuples.
 *
 * @param <T> The type of element of which to contain
 */
public interface Tuple<T extends UObject> extends UObject, Serializable {
    /**
     * Given the provided array of elements-which are all subclasses of {@link UObject UObject}, this method
     * will generate a new {@link Tuple tuple} containing the provided elements, in their unchanged order.
     * If the array contains an element whose value is {@code null}, this will return a {@link Tuple tuple} which
     * contains a {@code null} value; thus validating the postulate that this method's contract is pure,
     * within the context of the provided array of elements.
     * @param elements The array of elements of which to derive the {@link Tuple tuple} from
     * @return The newly constructed {@link Tuple tuple}
     * @param <U> The type of {@link UObject subclass} to designate as the generic type of the {@link Tuple tuple}
     */
    @SafeVarargs
    static <U extends UObject> Tuple<U> of(U... elements) {
        return new ArrayTuple<>(elements);
    }

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
     * Performs a containment check on this tuple of the provided {@link UObject object} {@code obj},
     * according to the {@link Object#equals(Object) equality} of the objects in question. If this tuple allows
     * the containment of {@code null} values, an input value of {@code null} will result in a return value of
     * {@code true}; satisfying the aforementioned {@link Object#equals(Object) equality check} from an
     * object-oriented point of view. If the {@link UObject object} {@code obj} is determined to not be
     * contained within this {@link Tuple tuple}, this method will throw a
     * {@link TupleDoesNotContainElementException Tuple does not Contain Element Exception} to indicate the
     * absence of the provided input value.
     *
     * @param obj The {@link UObject object} of which to check for containment
     * @return {@code true} if this {@link Tuple tuple} contains the provided {@link UObject object} {@code obj},
     * according to the criteria described above
     * @throws TupleDoesNotContainElementException If this {@link Tuple tuple} does not contain the provided
     *                                             {@link UObject object} {@code obj}, according to the criteria described above
     */
    boolean contains(UObject obj) throws TupleDoesNotContainElementException;

    /**
     * Performs a containment check on this tuple of the provided {@link Tuple subtuple} {@code t},
     * where each element of the provided {@link Tuple subtuple} {@code t} is passed into
     * {@link #contains(UObject) a containment check}. If every test passes without encountering a
     * {@link TupleDoesNotContainElementException Tuple does not Contain Element Exception}, this
     * method will return {@code true}. If at least one of the test fails and a
     * {@link TupleDoesNotContainElementException Tuple does not Contain Element Exception} is thrown,
     * this method will throw a {@link TupleDoesNotContainSubtupleException Tuple does not Contain Subtuple Exception},
     * completing the karmic circle of containment.
     *
     * @param t The {@link Tuple subtuple} of which to check for containment
     * @return {@code true} if this {@link Tuple tuple} contains every element of the provided {@link Tuple subtuple} {@code t},
     * according to the criteria described above
     * @throws TupleDoesNotContainSubtupleException If this {@link Tuple tuple} does not contain every element of the
     *                                              provided {@link Tuple subtuple} {@code t}
     */
    boolean containsAll(Tuple<? extends T> t) throws TupleDoesNotContainSubtupleException;

    /**
     * Retrieves an element contained within this {@link Tuple tuple}, in accordance to the provided
     * {@link Integer index} {@code i}. Indexing begins at {@code 0}, and increments by {@code 1}
     * for each added element: thus the furthermost possible retrievable index is <code>this {@link Tuple tuple}'s
     * length - 1</code>. If an {@link Integer index} which does not conform to the aforementioned bounds
     * is to be encountered, this method will throw a
     * {@link TupleIndexOutOfBoundsException Tuple Index out of Bounds Exception} to indicate that the bounds of this
     * {@link Tuple tuple} has been exceeded by the aforementioned {@link Integer index} {@code i}.
     *
     * @param i The index of which the element of which to be retrieved should be identified by
     * @return The element corresponding to the provided {@link Integer index} {@code i}
     * @throws TupleIndexOutOfBoundsException When the provided {@link Integer index} {@code i} is
     *                                        {@link TupleIndexOutOfBoundsException out of bounds}
     */
    T get(int i) throws TupleIndexOutOfBoundsException;

    /**
     * Derives a {@link Stream stream} from the elements of this {@link Tuple tuple}.
     *
     * @return A {@link Stream stream} whose source is the elements of this {@link Tuple tuple}
     */
    Stream<? extends T> stream();

    /**
     * Derives an array from the elements of this {@link Tuple tuple}.
     *
     * @return An array whose source is the elements of this {@link Tuple tuple}
     */
    T[] toArray();

    /**
     * Derives a unique hash code of this {@link Tuple tuple}.
     *
     * @return A unique hash code of this {@link Tuple tuple}
     */
    int hashCode();

    /**
     * Checks for equality between this {@link Tuple tuple} and the provided {@link Object object} {@code obj}.
     * This will first check whether the provided {@link Object object} {@code obj} is a {@link Tuple tuple}.
     * If the provided {@link Object object} {@code obj} is a {@link Tuple tuple}, it will then proceed to compare the
     * sizes of this {@link Tuple tuple} and the provided {@link Tuple tuple} {@code obj}.
     * If the sizes are equal between the two {@link Tuple tuples}, it will then proceed to iterate through
     * each pair of elements, checking for {@link Object#equals(Object) equality}. If every pair of object
     * can be {@link Object#equals(Object) considered equal}, it will then proceed to return {@code true}.
     * If any of the aforementioned axiom tests are to fail, it will halt the process and immediately return {@code false}.
     * To put it simply: The size and composition of the two tuples are compared.
     *
     * @param obj The {@link Object object} of which to compare this {@link Tuple tuple} against
     * @return {@code true} if the provided {@link Object object} {@code obj} is
     * {@link Object#equals(Object) considered to be equal} to that of this {@link Tuple tuple}
     */
    boolean equals(Object obj);

    /**
     * Parses the contents of this {@link Tuple tuple} into a human-readable {@link String string},
     * in the format of {@code "[e0, e1, e2...]"} where the number following {@code e} represents the index of the element,
     * and the content represents the {@link Object#toString() serialization of the individual elements}.
     *
     * @return A {@link String string} representation of this {@link Tuple tuple}
     */
    String toString();
}
