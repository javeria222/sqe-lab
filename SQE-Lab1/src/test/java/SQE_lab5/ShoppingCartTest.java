package SQE_lab5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ShoppingCartTest {

    private static final double DELTA = 0.001;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("REQ-1: adding an item puts it in the cart")
    void addItemAddsItem() {
        cart.addItem("Pen", 10.0, 2);
        assertAll("cart after adding one item",
                () -> assertEquals(2, cart.getItemCount()),
                () -> assertEquals(20.0, cart.getTotal(), DELTA));
    }

    @Test
    @DisplayName("REQ-1: adding the same item again increases its quantity")
    void addingSameItemIncreasesQuantity() {
        cart.addItem("Pen", 10.0, 2);
        cart.addItem("Pen", 10.0, 3);
        assertAll("cart after adding Pen twice",
                () -> assertEquals(5, cart.getItemCount()),
                () -> assertEquals(50.0, cart.getTotal(), DELTA));
    }

    @ParameterizedTest
    @CsvSource({
            "'', 10.0, 1",
            "'  ', 10.0, 1",
            "Pen, 0, 1",
            "Pen, -5.0, 1",
            "Pen, 10.0, 0",
            "Pen, 10.0, -1"
    })
    @DisplayName("REQ-2: bad name, price or quantity throws an error")
    void invalidItemThrows(String name, double price, int quantity) {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(name, price, quantity));
    }

    @Test
    @DisplayName("REQ-3: total is the sum of price x quantity")
    void totalIsSumOfPriceTimesQuantity() {
        cart.addItem("Pen", 10.0, 2);
        cart.addItem("Book", 25.5, 1);
        assertEquals(45.5, cart.getTotal(), DELTA);
    }

    @Test
    @DisplayName("REQ-3: empty cart has a total of 0")
    void emptyCartTotalIsZero() {
        assertEquals(0.0, cart.getTotal(), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 100.0",
            "10, 90.0",
            "25, 75.0",
            "50, 50.0"
    })
    @DisplayName("REQ-4: valid discounts reduce the total")
    void validDiscountReducesTotal(int percent, double expectedTotal) {
        cart.addItem("Shoes", 100.0, 1);
        cart.applyDiscount(percent);
        assertEquals(expectedTotal, cart.getTotal(), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"-1", "51", "100", "-50"})
    @DisplayName("REQ-4: discounts outside 0 to 50 throw an error")
    void invalidDiscountThrows(int percent) {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscount(percent));
    }

    @Test
    @DisplayName("REQ-5: removing an item in the cart returns true")
    void removeExistingItemReturnsTrue() {
        cart.addItem("Pen", 10.0, 2);
        assertAll("after removing Pen",
                () -> assertTrue(cart.removeItem("Pen")),
                () -> assertEquals(0, cart.getItemCount()),
                () -> assertEquals(0.0, cart.getTotal(), DELTA));
    }

    @Test
    @DisplayName("REQ-5: removing an item not in the cart returns false")
    void removeMissingItemReturnsFalse() {
        cart.addItem("Pen", 10.0, 2);
        assertFalse(cart.removeItem("Laptop"));
    }

    @Test
    @DisplayName("REQ-6: item count is the total quantity of all items")
    void itemCountIsTotalQuantity() {
        cart.addItem("Pen", 10.0, 2);
        cart.addItem("Book", 25.5, 3);
        assertEquals(5, cart.getItemCount());
    }
}