package dev.yeferson.model;

public  class Account {

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

    public void deposit(double amount) {
        balance += amount;
        numberOfDeposits++;
    }

    public void withdraw(double amount) {
        balance -= amount;
        numberOfWithdrawals++;
    }
    
}
