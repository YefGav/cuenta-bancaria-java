package dev.yeferson.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.closeTo;

public class CheckingAccountTest {

     private CheckingAccount account;

    @BeforeEach
    public void setUp() {
       
        account = new CheckingAccount(1000.0, 3.0);
    }

    @Test
    public void testWithdraw() {
      
        account.withdraw(500.0);
      
        assertThat(account.getBalance(), equalTo(500.0));
        assertThat(account.getNumberOfWithdrawals(), equalTo(1));
    }

    @Test
    public void testWithdrawWithOverdraft() {
      
        account.withdraw(1500.0);
      
        assertThat(account.getBalance(), equalTo(-500.0));
        assertThat(account.getOverdraft(), equalTo(500.0));
        assertThat(account.getNumberOfWithdrawals(), equalTo(1));
    }

    @Test
    public void testDepositReducesOverdraft() {
       
        account.withdraw(1500.0);
        account.deposit(300.0);

        assertThat(account.getOverdraft(), equalTo(200.0));
        assertThat(account.getBalance(), equalTo(-200.0));
        assertThat(account.getNumberOfDeposits(), equalTo(1));
    }

    @Test
    public void testMonthlyStatement() {
      
        account.withdraw(500.0);  
        account.deposit(200.0);     
     
        account.setMonthlyCommission(50.0);
        double previousBalance = account.getBalance();
       
        account.monthlyStatement();
        
        double expectedInterest = (previousBalance - 50.0) * 0.0025;
        double expectedBalance = (previousBalance - 50.0) + expectedInterest;
        assertThat(account.getBalance(), closeTo(expectedBalance, 0.001));
    }
}
