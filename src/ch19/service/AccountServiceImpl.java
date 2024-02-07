package ch19.service;

import ch19.dao.IAccountDAO;
import ch19.dto.AccountInsertDTO;
import ch19.dto.UserInsertDTO;
import ch19.model.Account;
import ch19.model.User;
import ch19.service.exceptions.*;

public class AccountServiceImpl implements IAccountService {
    private IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public Account insertAccount(AccountInsertDTO accountInsertDTO) throws IdAlreadyExistsException {
        Account mappedAcc = mapAccount(accountInsertDTO);

        if (dao.findById(mappedAcc.getId()) != null) {
            throw new IdAlreadyExistsException(mappedAcc);
        }
        return dao.insert(mappedAcc);
    }

    @Override
    public void deleteAccount(Long accountId) throws AccountNotFoundException {
        if (dao.findById(accountId) == null) {
            throw new AccountNotFoundException(accountId);
        }
        dao.delete(accountId);
    }

    @Override
    public Account getAccount(Long accountId) throws AccountNotFoundException {
        if (dao.findById(accountId) == null) {
            throw new AccountNotFoundException(accountId);
        }
        return dao.findById(accountId);
    }

    @Override
    public void deposit(Long accountId, double amount) throws NegativeAmountException, AccountNotFoundException {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }
        Account account = dao.findById(accountId);
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount, String ssn) throws SsnNotValidException, InsufficientBalanceException {
        Account account = dao.getAll().values().stream()
                .filter(acc -> acc.getHolder().getSsn().equals(ssn))
                .findFirst()
                .orElse(null);

        if (account == null) {
            throw new SsnNotValidException(ssn);
        }
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException(account,amount);
        }

        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public Double getAccountBalance(Long accountId, String ssn) throws AccountNotFoundException, SsnNotValidException {
        Account account = dao.findById(accountId);
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }

        if (!account.getHolder().getSsn().equals(ssn)) {
            throw new SsnNotValidException(ssn);
        }
        return account.getBalance();

    }

    private static Account mapAccount(AccountInsertDTO accountInsertDTO) {
        return new Account(accountInsertDTO.getId(), accountInsertDTO.getIban(),mapUser(accountInsertDTO.getUserInsertDTO()),accountInsertDTO.getBalance());
    }

    private static User mapUser (UserInsertDTO userInsertDTO) {
        return new User(userInsertDTO.getId(), userInsertDTO.getFirstname(), userInsertDTO.getLastname(), userInsertDTO.getSsn());
    }
}