package dev.yeferson.model;

public class Account {

    protected double balance;
    protected int numberOfDeposits;
    protected int numberOfWithdrawals;
    protected double annualInterestRate;
    protected double monthlyCommission;

    public Account(double balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumberOfDeposits() {
        return numberOfDeposits;
    }

    public int getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyCommission() {
        return monthlyCommission;
    }

    public void setMonthlyCommission(double monthlyCommission) {
        this.monthlyCommission = monthlyCommission;
    }

    public void deposit(double amount) {
        balance += amount;
        numberOfDeposits++;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
        this.numberOfWithdrawals++;
    }

    public double calculateMonthlyInterest() {
        double monthlyRate = this.annualInterestRate / 12 / 100;
        return this.balance * monthlyRate;
    }

    public void monthlyStatement() {
        this.balance -= this.monthlyCommission;
        this.balance += calculateMonthlyInterest();
    }

    public String print() {
        return "Balance: " + this.balance +
                ", Deposits: " + this.numberOfDeposits +
                ", Withdrawals: " + this.numberOfWithdrawals +
                ", Monthly Commission: " + this.monthlyCommission;
    }

}
