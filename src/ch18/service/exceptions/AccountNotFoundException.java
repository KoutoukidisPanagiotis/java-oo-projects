package ch18.service.exceptions;

public class AccountNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AccountNotFoundException(long id) {
        super("Account not found for ID: " + id);
    }
}
