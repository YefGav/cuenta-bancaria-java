package dev.yeferson;

import dev.yeferson.model.Account;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTest {

    @Test

    public void testAccountConstructor() {
        Account account = new Account(10000.0, 5.0);
        assertThat(account.getBalance(), equalTo(10000.0));
        assertThat(account.getAnnualInterestRate(), equalTo(5.0));
        assertThat(account.getNumberOfDeposits(), equalTo(0));
        assertThat(account.getNumberOfWithdrawals(), equalTo(0));
        assertThat(account.getMonthlyCommission(), equalTo(0.0));
    }

}
