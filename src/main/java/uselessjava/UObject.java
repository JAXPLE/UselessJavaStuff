package uselessjava;

import uselessjava.exception.RussianRouletteLostException;
import uselessjava.exception.UException;

import java.awt.*;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * A UselessJava object. (hereafter referred to as "object")
 * All UselessJava classes implement this interface.
 * </p>
 * <p>
 * Objects contain various default methods such as
 * {@link #generateRandomIdentifier() generating a random UUID},
 * {@link #generateColor(int, int, int) generating a Color}, or
 * {@link #generateString(UObject) generating a String}.
 * These methods can be overloaded to suit the various needs of subclasses and subinterfaces.
 * </p>
 *
 * @see Object
 */
public interface UObject {
    /**
     * Generates a random {@link UUID unique identifier}.
     *
     * @return A random {@link UUID unique identifier}
     */
    default UUID generateRandomIdentifier() {
        return UUID.randomUUID();
    }

    /**
     * Generates a {@link Color color}. All values must be within the range of {@code [0, 255]}.
     *
     * @param red   The red value of the {@link Color color} of which to generate
     * @param green The green value of the {@link Color color} of which to generate
     * @param blue  The blue value of the {@link Color color} of which to generate
     * @return The generated {@link Color color}
     * @throws IllegalArgumentException When an illegal value is provided as an RGB value
     */
    default Color generateColor(int red, int green, int blue) throws IllegalArgumentException {
        return new Color(red, green, blue);
    }

    /**
     * Generates a {@link String string} from the provided {@code source} {@link UObject object}.
     *
     * @param source The source {@link UObject object} of which to generate the string from
     * @return The generated {@link String string}
     */
    default String generateString(UObject source) {
        return String.valueOf(source);
    }

    /**
     * Throws a {@link UException soft runtime exception} and halts the current thread when thrown naked.
     *
     * @throws UException Always
     */
    default void throwRuntimeException() throws UException {
        throw new UException("The developer has decided to throw a runtime exception.");
    }

    /**
     * Returns a reference to this instance. ({@code this})
     *
     * @return {@code this}
     */
    default UObject getThis() {
        return this;
    }

    /**
     * Performs a Russian Roulette using a {@link Random random number generator}.
     * If the random number value is less than {@code 1.0 / 6.0}, the shot is fired.
     * If the shot is fired, this method will throw a {@link RussianRouletteLostException soft runtime exception}
     * and will halt the current thread when left naked.
     *
     * @throws RussianRouletteLostException This method has a {@code 1/6} chance to throw an exception
     */
    default void russianRoulette() throws RussianRouletteLostException {
        Random random = new Random();
        double randomValue = random.nextDouble();
        boolean safe = randomValue >= (1d / 6d);

        if (safe) return;

        throw new RussianRouletteLostException();
    }
}
