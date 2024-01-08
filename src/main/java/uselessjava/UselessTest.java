package uselessjava;

import uselessjava.customer.Customer;

/**
 * <p>
 * Used for UselessJavaStuff testing.
 * </p>
 */
public class UselessTest implements UObject {
    /**
     * The main method of this class.
     *
     * @param args The array of initial arguments
     */
    public static void main(String[] args) {
        Customer user = new Customer("Jack");

        user.russianRoulette();
        user.russianRoulette();
        user.russianRoulette();
        user.russianRoulette();
        user.russianRoulette();
        user.russianRoulette();

        System.out.println(user.getUsername());
    }
}
