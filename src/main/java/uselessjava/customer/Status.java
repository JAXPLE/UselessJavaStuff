package uselessjava.customer;

public enum Status {
    LIVE(Boolean.TRUE),
    DIE(Boolean.FALSE);

    public final boolean status;

    Status(Boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
