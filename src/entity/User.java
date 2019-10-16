package entity;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private Date created_at;
    private BankAccountInterface bankAccount;

    public User(String username, String password, Date created_at, BankAccountInterface bankAccount) {
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.bankAccount = bankAccount;
    }

    public boolean sendMoney(User user, double amount)
    {
        return Bank.getInstance().requestTransfer(this, user, amount);
    }

    public boolean login(String password)
    {
        return password.equals("hardcode");
    }

    public BankAccountInterface getBankAccount() {
        return bankAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
