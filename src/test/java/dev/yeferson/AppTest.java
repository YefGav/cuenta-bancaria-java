package dev.yeferson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    public void testMonthlyStatement() {
        account.monthlyCommission = 50.0;
        // El interés mensual de 1000 con 12% anual es 10.0 (1% de 1000)
        account.monthlyStatement();
        // Saldo esperado: 1000 - 50 + 10 = 960
        assertThat(account.getBalance(), closeTo(960.0, 0.001));
    }
}
