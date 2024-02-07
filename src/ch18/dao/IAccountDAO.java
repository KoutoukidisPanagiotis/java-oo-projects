package ch18.dao;

import ch18.model.Account;

import java.util.List;

public interface IAccountDAO {

    Account insert(Account account);

    void update(Account oldAccount, Account newAccount);
    void delete(Long id);
    Account findById(Long id);

    List<Account> getAll();


}
