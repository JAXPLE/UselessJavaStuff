package uselessjava;

import uselessjava.customer.Customer;
import uselessjava.tuple.Tuple;

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
        Tuple<Customer> customers = Tuple.of(
                new Customer("hi mom"),
                new Customer("hello world"),
                new Customer("jack")
        );

        System.out.println(customers);
    }
}
