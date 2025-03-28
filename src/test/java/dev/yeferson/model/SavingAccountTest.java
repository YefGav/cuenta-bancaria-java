package dev.yeferson.model;

import org.junit.jupiter.api.BeforeEach;
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
}
