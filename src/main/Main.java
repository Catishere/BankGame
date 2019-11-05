package main;

import main.banking.Bank;
import main.model.User;

public class Main {

    public static void main(String[] args) {
        User user = Bank.getInstance().openAccount("Wiki", "parola", 50.0);
        User user2 = Bank.getInstance().openAccount("Bobi", "parol1a", 30.0);
        User user3 = Bank.getInstance().openAccount("Niki", "parola2", 510.0);

        System.out.println(user.getBankAccount().getBalance());
        user.sendMoney(user2, 15);
        System.out.println(user.getBankAccount().getBalance());
        System.out.println(user2.getBankAccount().getBalance());
    }
}
