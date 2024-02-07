package ch18.dao;

import ch18.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO {
    private static final List<Account> accounts = new ArrayList<>();
    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public void update(Account oldAccount, Account newAccount) {
        if (accounts.contains(oldAccount)) {
            accounts.set(accounts.indexOf(oldAccount), newAccount);
        }
    }

    @Override
    public void delete(Long id) {
        accounts.removeIf(account -> account.getId().equals(id));
    }

    @Override
    public Account findById(Long id) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }
}
