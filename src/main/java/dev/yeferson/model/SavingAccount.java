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

    @Override
    public void withdraw(double amount) {

        if (!active) {
            throw new IllegalArgumentException("Account is inactive, cannot withdraw");
        }

        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        this.balance -= amount;
        this.numberOfWithdrawals++;

        if (this.balance < 10000.0) {
            this.active = false;
        }
    }

    @Override
    public void monthlyStatement() {
        int extraWithdrawals = Math.max(0, this.numberOfWithdrawals - 4);
        this.monthlyCommission = extraWithdrawals * 1000.0;
        super.monthlyStatement();
        active = this.balance >= 10000.0;
    }
}
