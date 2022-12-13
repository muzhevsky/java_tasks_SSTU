package com.muzhesky.shareBots;

public class Account {
    private double balance;

    public void addMoney(double value) {
        balance += value;
    }

    public void spendMoney(double value) {
        if (balance < value) {
            System.out.println("not enough money");
            return;
        }

        balance -= value;
    }

    public double getBalance() {
        return balance;
    }
}