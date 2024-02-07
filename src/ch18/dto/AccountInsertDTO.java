package ch18.dto;

import java.util.Objects;

public class AccountInsertDTO extends BaseDTO{

    private String iban;
    private UserInsertDTO userInsertDTO;
    private double balance;

    public AccountInsertDTO() {
    }

    public AccountInsertDTO(Long id, String iban,UserInsertDTO userInsertDTO, double balance) {
        setId(id);
        this.userInsertDTO = userInsertDTO;
        this.iban = iban;
        this.balance = balance;
    }

    public UserInsertDTO getUserInsertDTO() {
        return userInsertDTO;
    }

    public void setUserInsertDTO(UserInsertDTO userInsertDTO) {
        this.userInsertDTO = userInsertDTO;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountInsertDTO that = (AccountInsertDTO) o;

        if (Double.compare(balance, that.balance) != 0) return false;
        if (!Objects.equals(userInsertDTO, that.userInsertDTO))
            return false;
        return Objects.equals(iban, that.iban);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userInsertDTO != null ? userInsertDTO.hashCode() : 0;
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AccountInsertDTO{" +
                "userInsertDTO=" + userInsertDTO +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
