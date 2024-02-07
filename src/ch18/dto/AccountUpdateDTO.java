package ch18.dto;

import java.util.Objects;

public class AccountUpdateDTO extends BaseDTO {

    private String iban;
    private double balance;

    public AccountUpdateDTO() {
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountUpdateDTO{" +
                "Iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountUpdateDTO that = (AccountUpdateDTO) o;

        if (Double.compare(balance, that.balance) != 0) return false;
        return Objects.equals(iban, that.iban);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iban != null ? iban.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}