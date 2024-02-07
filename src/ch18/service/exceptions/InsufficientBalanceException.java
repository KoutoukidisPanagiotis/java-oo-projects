package ch18.service.exceptions;

import ch18.model.Account;

public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(Account account, double amount) {
        super("Insufficient balance " + account.getBalance() + " for amount " + amount);
    }
}
