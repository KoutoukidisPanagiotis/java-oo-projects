package ch19.model;

import java.util.Objects;

public class Account extends AbstractEntity {

    private String iban;
    private User holder;
    private double balance;

    public Account() {
    }

    public Account(Long id, String iban, User holder, double balance) {
        setId(id);
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public User getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", holder=" + holder +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(balance, account.balance) != 0) return false;
        if (!Objects.equals(iban, account.iban)) return false;
        return Objects.equals(holder, account.holder);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iban != null ? iban.hashCode() : 0;
        result = 31 * result + (holder != null ? holder.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
