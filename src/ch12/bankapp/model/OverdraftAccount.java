package ch12.bankapp.model;

/**
 * Represents an Overdraft Account with the ability to deposit and withdraw funds,
 * and provides information about the account holder.
 */
public class OverdraftAccount {
    private int id;
    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public OverdraftAccount() {
    }

    public OverdraftAccount(int id, String iban, String firstname, String lastname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Deposits a specified amount into the account.
     * @param amount        The amount to deposit.
     * @throws Exception    If the specified amount is negative.
     */
    public void deposit (double amount) throws Exception {
        try {
            if (amount < 0) {
                throw new Exception("Negative amount exception.");
            }
            balance += amount;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Withdraws a specified amount from the account.
     * @param amount    The amount to withdraw.
     * @param ssn       The Social Security Number for validation.
     * @throws Exception If the SSN is not valid.
     */
    public void withdraw(double amount,String ssn) throws Exception{
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Ssn not valid exception.");
            }
            balance -= amount;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets the account balance.
     * @return      the account balance.
     */
    public double getAccountBalance() {
        return getBalance();
    }

    /**
     * Converts the overdraft account to a String.
     * @return      the String.
     */
    public String accountToString() {
        return "OverdraftAccount{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn='" + ssn + '\'' +
                ", balance=" + balance +
                '}';
    }

    private boolean isSsnValid(String ssn) {
        return this.ssn.equals(ssn);
    }
}
