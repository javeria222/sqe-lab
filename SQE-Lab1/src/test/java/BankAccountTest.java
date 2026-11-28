/*
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Ayesha", 1000);
    }

    @Test
    @DisplayName("New account keeps the opening balance")
    void newAccountHasOpeningBalance() {
        assertEquals(1000, account.getBalance(),
                "Opening balance should be 1000");
    }
    @Test
    void depositIncreasesBalance() {
        account.deposit(500); // Act
        assertEquals(1500, account.getBalance()); // Assert
    }
    @Test
    void withdrawDecreasesBalance() {
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }
    @Test
    void withdrawingAllMoneyGivesZeroBalance() {
        account.withdraw(1000);
        assertEquals(0, account.getBalance());
    }

    @Test
    void depositNegativeAmountThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-100));
        assertEquals("Amount must be positive", ex.getMessage());
    }

    @Test
    void withdrawMoreThanBalanceThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(5000));
        assertEquals("Insufficient balance", ex.getMessage());
    }

    @Disabled("Interest feature is not built yet")
    @Test
    void interestIsAddedToBalance() {
        assertEquals(1050, account.getBalance());
    }

    @Test
    void accountDetailsAreStored() {
        assertNotNull(account.getHolder());
        assertAll("account details",
                () -> assertEquals("Ayesha", account.getHolder()),
                () -> assertEquals(1000, account.getBalance()));
    }





}
*/