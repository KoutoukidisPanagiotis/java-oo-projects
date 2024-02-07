package ch19.service.exceptions;

public class NegativeAmountException extends Exception {
    private static final long serialVersionUID = 1L;

    public NegativeAmountException(double amount) {
        super("Amount " + amount + " is not sufficient.");
    }
}
