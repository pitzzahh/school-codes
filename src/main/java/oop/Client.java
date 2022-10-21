package oop;

public class Client {

    private boolean hasAccess;
    private int pin;

    public Client() {
        this(false);
    }

    public Client(boolean hasAccess) {
        this(hasAccess, 5155);
    }

    public Client(int pin) {
        this(false, pin);
    }

    public Client(boolean hasAccess, int pin) {
        this.hasAccess = hasAccess;
        this.pin = pin;
    }

}














