package dev.yeferson.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
}
