package uselessjava;

import uselessjava.customer.Customer;
import uselessjava.customer.Status;
import uselessjava.exception.RussianRouletteLostException;
import uselessjava.exception.UException;

/**
 * <p>
 * Used for UselessJavaStuff testing.
 * </p>
 */
public class UselessTest extends UException implements UObject {
    /**
     * The main method of this class.
     *
     * @param args The array of initial arguments
     */
    public static void main(String[] args) {
        Customer user = new Customer()
                .name("jack")
                .status(Status.LIVE)
                .build();

        while (user.russianRoulette().status) {
            user.russianRoulette();
        }

        throw new RussianRouletteLostException();
    }
}
