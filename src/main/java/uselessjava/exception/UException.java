package uselessjava.exception;

import uselessjava.UObject;

import java.util.Objects;

/**
 * <p>
 * A UselessJava {@link RuntimeException runtime exception}.
 * (hereafter referred to as "exception")
 * All UselessJava exceptions are subclasses of this class.
 * </p>
 * <p>
 * Exceptions can be created either with the default detail message
 * {@code "The developer has messed up"}, or can be {@link #UException(String) manually specified}.
 * A cause can also be specified: either {@link #UException(String, Throwable)} with a detail message};
 * or {@link #UException(Throwable) with the default detail message}.
 * </p>
 *
 * @see UObject
 */
public class UException extends RuntimeException implements UObject {
    /**
     * Creates a new {@link UException exception}.
     */
    public UException() {
        super("The developer has messed up.");
    }

    /**
     * Creates a new {@link UException exception} whose detail message will be specified as
     * the provided input parameter {@code message}.
     *
     * @param message The detail message this {@link UException exception} should display
     * @throws NullPointerException When the provided input parameter {@code message} is {@code null}
     */
    public UException(String message) {
        super(Objects.requireNonNull(message, "The developer has messed up an Exception constructor."));
    }

    /**
     * Creates a new {@link UException exception} whose detail message will be specified as
     * the provided input parameter {@code message}, and whose cause will be specified as
     * the provided input parameter {@link Throwable cause}.
     *
     * @param message The detail message this {@link UException exception} should display
     * @param cause   The cause of this {@link UException exception}
     * @throws NullPointerException When the provided input parameter {@code message} is {@code null}
     */
    public UException(String message, Throwable cause) {
        super(Objects.requireNonNull(message, "The developer has messed up an Exception constructor."), cause);
    }

    /**
     * Creates a new {@link UException exception} whose cause will be specified as
     * the provided input parameter {@link Throwable cause}.
     *
     * @param cause The cause of this {@link UException exception}
     */
    public UException(Throwable cause) {
        super(cause);
    }
}
