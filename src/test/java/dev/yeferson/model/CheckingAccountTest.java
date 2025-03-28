package dev.yeferson.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

     private CheckingAccount account;

    @BeforeEach
    public void setUp() {
       
        account = new CheckingAccount(1000.0, 3.0);
    }

    @Test
    public void testWithdrawWithOverdraft() {
        // Se retira 1500, lo que supera el saldo en 500.
        account.withdraw(1500.0);
        // Se espera que el balance sea -500
        assertThat(account.getBalance(), equalTo(-500.0));
        // Se espera que el overdraft sea 500
        assertThat(account.getOverdraft(), equalTo(500.0));
        // Se espera que el contador de retiros sea 1.
        assertThat(account.getNumberOfWithdrawals(), equalTo(1));
    }
}
