package dev.yeferson.model;

public class SavingAccount extends Account {

    private boolean active;

    public SavingAccount(double balance, double annualInterestRate) {
        super(balance, annualInterestRate);
        this.active = balance >= 10000.0;
    }

    public boolean isActive() {
        return active;
    }
}
