package dev.yeferson.model;

public class CheckingAccount extends Account {

    private double overdraft;

    public CheckingAccount(double balance, double annualInterestRate) {

        super(balance, annualInterestRate);
        
    }

    public CheckingAccount(double balance, double annualInterestRate, double overdraft) {
        super(balance, annualInterestRate);
        this.overdraft = 0.0;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(double amount) {
        
        if (amount > this.balance) {
            double overdraftNeeded = amount - this.balance;
            this.overdraft += overdraftNeeded;
            
            this.balance -= amount;
        } else {
          
            this.balance -= amount;
        }
        this.numberOfWithdrawals++;
    }

    
}
