package dev.yeferson;

import dev.yeferson.model.Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(5000.0, 3.0);
    }
    @Test

    public void testAccountConstructor() {
        Account account = new Account(5000.0, 3.0);
        assertThat(account.getBalance(), equalTo(5000.0));
        assertThat(account.getAnnualInterestRate(), equalTo(3.0));
        assertThat(account.getNumberOfDeposits(), equalTo(0));
        assertThat(account.getNumberOfWithdrawals(), equalTo(0));
        assertThat(account.getMonthlyCommission(), equalTo(0.0));
    }

    @Test
    
    public void testDepositIncreasesBalance() {
        account.deposit(500.0);
        assertThat(account.getBalance(), equalTo(5500.0));
        assertThat(account.getNumberOfDeposits(), equalTo(1));
    }
    
    @Test

     public void testWithdrawDecreasesBalance() {
        account.withdraw(300.0);
        assertThat(account.getBalance(), equalTo(4700.0));
        assertThat(account.getNumberOfWithdrawals(), equalTo(1));
    }

  

}
