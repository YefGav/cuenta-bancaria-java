package dev.yeferson.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SavingAccountTest {

    private SavingAccount account;

    @BeforeEach
    public void setUp() {
        account = new SavingAccount(5000.0, 3.0);
    }

    @Test
    public void testAccountIsInactive() {
        assertThat(account.isActive(), equalTo(false));
    }

    @Test
    public void testDepositActivateAccount() {

        account.deposit(6000.0);
        assertThat(account.getBalance(), equalTo(11000.0));
        assertThat(account.isActive(), equalTo(true));
        assertThat(account.getNumberOfDeposits(), equalTo(1));
    }

    @Nested
    
    public class SavingsAccountWithdrawTest {

        private SavingAccount account;

        @BeforeEach
        public void setUp() {

            account = new SavingAccount(15000.0, 3.0);
        }

        @Test
        public void testWithdrawRemainsActive() {

            account.withdraw(5000.0);
            assertThat(account.getBalance(), equalTo(10000.0));
            assertThat(account.isActive(), equalTo(true));
            assertThat(account.getNumberOfWithdrawals(), equalTo(1));
        }

        @Test
        public void testWithdrawDeactivatesAccount() {

            account.withdraw(6000.0);
            assertThat(account.getBalance(), equalTo(9000.0));
            assertThat(account.isActive(), equalTo(false));
            assertThat(account.getNumberOfWithdrawals(), equalTo(1));
        }

        @Test
        public void testMonthlyStatementCommission() {

            account.withdraw(1000.0);
            account.withdraw(1000.0);
            account.withdraw(1000.0);
            account.withdraw(1000.0);
            account.withdraw(1000.0);

            account.monthlyStatement();

            assertThat(account.getMonthlyCommission(), equalTo(1000.0));
            assertThat(account.isActive(), equalTo(true));
        }
    }
}
