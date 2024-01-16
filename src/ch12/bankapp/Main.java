package ch12.bankapp;

import ch12.bankapp.model.JointAccount;
import ch12.bankapp.model.OverdraftAccount;

public class Main {
    public static void main(String[] args) {
        OverdraftAccount over1 = new OverdraftAccount(123, "gr1234567", "Panagiotis", "Koutoukidis", "12345", 500.0);
        JointAccount joint1 = new JointAccount(1, 2, "gr10", "Panagiotis", "Giannis", "Koutoukidis", "Giannakis", "1", "2", 1000.0);

        System.out.println(over1.accountToString());
        System.out.println(joint1.accountToString());

        try {
            over1.withdraw(600, "12345");
            over1.deposit(50);
            System.out.println(over1.getAccountBalance());
            joint1.withdraw(900, "1");
            System.out.println(joint1.getBalance());
            joint1.withdraw(200, "2");
        } catch (Exception e) {
            System.err.println("Something unexpected happened");
        }
    }
}