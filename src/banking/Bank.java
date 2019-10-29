package banking;

import model.BankAccountInterface;
import model.User;
import security.ReflectionSecurityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Bank {

    private List<BankAccount> accounts = new ArrayList<>();
    private static Bank ourInstance = new Bank();

    public static Bank getInstance() {
        return ourInstance;
    }

    private Bank() {
        try {
            System.setSecurityManager(new ReflectionSecurityManager());
        } catch (SecurityException se) {
            System.out.println("Double call.");
        }
    }

    private boolean hasAccount(BankAccount bankAccount)
    {
        return accounts.contains(bankAccount);
    }

    public boolean requestTransfer(User user1, User user2, double amount)
    {
        BankAccount ba1 = (BankAccount) user1.getBankAccount();
        BankAccount ba2 = (BankAccount) user2.getBankAccount();
        if (!(hasAccount(ba1) && hasAccount(ba2)))
            return false;

        if (ba1.getBalance() >= amount)
        {
            ba1.setBalance(ba1.getBalance() - amount);
            ba2.setBalance(ba2.getBalance() + amount);
            return true;
        }
        return false;
    }

    public User openAccount(String name, String password, double startBalance)
    {
        BankAccount bankAccount = new BankAccount(startBalance);
        User user = new User(name, password, new Date(), bankAccount);
        bankAccount.setUser(user);
        accounts.add(bankAccount);
        return user;
    }

    private class BankAccount implements BankAccountInterface {
        private double balance;
        private User user;

        private BankAccount(double balance) {
            this.balance = balance;
        }

        @Override
        public double getBalance() {
            return balance;
        }

        @Override
        public User getUser() {
            return user;
        }

        private void setUser(User user) {
            this.user = user;
        }

        private void setBalance(double balance)
        {
            this.balance = balance;
        }

    }
}
