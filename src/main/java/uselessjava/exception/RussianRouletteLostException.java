package uselessjava.exception;

import uselessjava.UObject;

/**
 * <p>
 * Thrown when a {@link UObject#russianRoulette() game of Russian Roulette} is lost.
 * </p>
 */
public class RussianRouletteLostException extends UException {
    /**
     * Creates a new {@link RussianRouletteLostException Russian Roulette Lost Exception}.
     */
    public RussianRouletteLostException() {
        super("The developer has decided to try their chances on a game of Russian Roulette. They have lost.");
    }
}
