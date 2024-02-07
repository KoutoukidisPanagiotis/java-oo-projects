package ch19.service.exceptions;

import ch19.model.Account;

public class IdAlreadyExistsException extends Exception{
    private static final long serialVersionUID =1L;

    public IdAlreadyExistsException(Account account) {
        super("Account with id " + account.getId() + " already exists.");
    }
}


