package ch12.bankapp.model;

/**
 * Represents a Joint Account with the ability to deposit and withdraw funds,
 * and provides information about the account holders.
 */
public class JointAccount {
    private int id;
    private int id2;
    private String iban;
    private String firstname;
    private String firstname2;
    private String lastname;
    private String lastname2;
    private String ssn;
    private String ssn2;
    private double balance;

    public JointAccount() {
    }

    public JointAccount(int id, int id2, String iban, String firstname, String firstname2, String lastname, String lastname2, String ssn, String ssn2, double balance) {
        this.id = id;
        this.id2 = id2;
        this.iban = iban;
        this.firstname = firstname;
        this.firstname2 = firstname2;
        this.lastname = lastname;
        this.lastname2 = lastname2;
        this.ssn = ssn;
        this.ssn2 = ssn2;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
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

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Converts the joint account details to a String.
     * @return      the String implementation.
     */
    public String accountToString() {
        return "JointAccount{" +
                "id=" + id +
                ", id2=" + id2 +
                ", iban='" + iban + '\'' +
                ", firstname='" + firstname + '\'' +
                ", firstname2='" + firstname2 + '\'' +
                ", lastname='" + lastname + '\'' +
                ", lastname2='" + lastname2 + '\'' +
                ", ssn='" + ssn + '\'' +
                ", ssn2='" + ssn2 + '\'' +
                ", balance=" + balance +
                '}';
    }

    /**
     * Deposits a specified amount into the joint account.
     * @param amount      The amount to deposit.
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
     * Withdraws a specified amount from the joint account.
     * @param amount    The amount to withdraw.
     * @param ssn       The Social Security Number for validation.
     * @throws Exception    If the SSN is not valid or the withdrawal amount is larger than the balance.
     */
    public void withdraw(double amount,String ssn) throws Exception{
        try {
            if (!isSsnValid(ssn)) {
                throw new Exception("Ssn not valid exception.");
            }
            if (amount > balance) {
                throw new Exception("Insufficient funds exception.");
            }
            balance -= amount;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets the joint account balance.
     * @return      The joint account balance.
     */
    public double getAccountBalance() {
        return getBalance();
    }

    private boolean isSsnValid(String ssn) {
        return this.ssn.equals(ssn) || this.ssn2.equals(ssn);
    }

}
