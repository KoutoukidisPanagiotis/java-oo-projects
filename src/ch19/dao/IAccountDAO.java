package ch19.dao;

import ch19.model.Account;

import java.util.Map;

public interface IAccountDAO {

    Account insert(Account account);

    void update(Account oldAccount, Account newAccount);
    void delete(Long id);
    Account findById(Long id);

    Map<Long, Account> getAll();


}
