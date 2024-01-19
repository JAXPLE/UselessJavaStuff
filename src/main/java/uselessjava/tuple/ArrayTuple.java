package uselessjava.tuple;

import uselessjava.UObject;
import uselessjava.exception.TupleDoesNotContainElementException;
import uselessjava.exception.TupleDoesNotContainSubtupleException;
import uselessjava.exception.TupleIndexOutOfBoundsException;

import java.io.Serial;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayTuple<T extends UObject> implements Tuple<T> {
    @Serial
    private static final long serialVersionUID = 420;

    private final T[] values;

    @SafeVarargs
    ArrayTuple(T... values) {
        this.values = Objects.requireNonNull(values);
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean contains(UObject obj) throws TupleDoesNotContainElementException {
        for (T value : values) {
            if (Objects.equals(value, obj)) return true;
        }

        throw new TupleDoesNotContainElementException();
    }

    @Override
    public boolean containsAll(Tuple<? extends T> t) throws TupleDoesNotContainSubtupleException {
        try {
            return t.stream().map(this::contains).reduce(false, (b1, b2) -> b1 || b2);
        } catch (TupleDoesNotContainElementException e) {
            throw new TupleDoesNotContainSubtupleException();
        }
    }

    @Override
    public T get(int i) throws TupleIndexOutOfBoundsException {
        try {
            return values[i];
        } catch (IndexOutOfBoundsException e) {
            throw new TupleIndexOutOfBoundsException();
        }
    }

    @Override
    public Stream<? extends T> stream() {
        return Stream.of(values);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Stream.of(values).toArray();
    }

    @Override
    public int hashCode() {
        return Objects.hash((Object[]) values);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tuple<?> t2)) return false;
        if (values.length != t2.size()) return false;

        for (int i = 0; i < values.length; i++) {
            if (!Objects.equals(values[i], t2.get(i))) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
