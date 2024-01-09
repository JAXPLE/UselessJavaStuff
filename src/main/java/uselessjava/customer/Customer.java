package uselessjava.customer;

import uselessjava.UObject;

public class Customer implements UObject {
    protected String username;
    protected Status status;

    public Customer() {}

    public Customer(String username, Status status) {
        this.username = username;
        this.status = status;
    }

    public Customer name(String name) {
        this.username = name;
        return this;
    }

    public Customer status(Status status) {
        this.status = status;
        return this;
    }

    public Customer build() {
        return new Customer(
                this.username,
                this.status
        );
    }
}
