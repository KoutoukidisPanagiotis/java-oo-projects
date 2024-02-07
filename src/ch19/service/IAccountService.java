package ch19.service;


import ch19.dto.AccountInsertDTO;
import ch19.model.Account;
import ch19.service.exceptions.*;

public interface IAccountService {
    Account insertAccount(AccountInsertDTO accountInsertDTO) throws IdAlreadyExistsException;

    //Account updateAccount(AccountUpdateDTO oldDto, AccountUpdateDTO newDto) throws AccountNotFoundException, IbanAlreadyExistsException,IdAlreadyExistsException;

    void deleteAccount(Long accountId) throws AccountNotFoundException;

    Account getAccount(Long accountId) throws AccountNotFoundException;

    void deposit (Long accountId, double amount) throws NegativeAmountException, AccountNotFoundException;

    void withdraw (double amount, String ssn) throws SsnNotValidException, InsufficientBalanceException;

    Double getAccountBalance(Long accountId, String ssn) throws AccountNotFoundException, SsnNotValidException;

}