package uselessjava.customer;

import uselessjava.UObject;

public class Customer implements UObject {
    protected final String username;

    public Customer(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
