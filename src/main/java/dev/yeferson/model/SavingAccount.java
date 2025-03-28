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

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (this.balance >= 10000.0) {
            this.active = true;
        }
    }
}
