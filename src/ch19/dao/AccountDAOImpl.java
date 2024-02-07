package ch19.dao;

import ch19.model.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountDAOImpl implements IAccountDAO {
    private static final Map<Long, Account> accounts = new HashMap<>();
    @Override
    public Account insert(Account account) {
        accounts.put(account.getId(),account);
        return account;
    }

    @Override
    public void update(Account oldAccount, Account newAccount) {
        accounts.remove(oldAccount.getId());
        accounts.put(newAccount.getId(),newAccount);
    }

    @Override
    public void delete(Long id) {
        accounts.remove(id);
    }

    @Override
    public Account findById(Long id) {
        return accounts.get(id);
    }

    @Override
    public Map<Long, Account> getAll() {
        return new HashMap<>(accounts);
    }


}
