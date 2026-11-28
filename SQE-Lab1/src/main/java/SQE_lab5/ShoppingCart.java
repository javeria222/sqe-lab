package SQE_lab5;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {
    private static class Item {
        double price;
        int quantity;

        Item(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }

    private final Map<String, Item> items = new LinkedHashMap<>();
    private int discountPercent = 0;

    public void addItem(String name, double price, int quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be more than 0");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be more than 0");
        }
        Item existing = items.get(name);
        if (existing != null) {
            existing.quantity += quantity;
        } else {
            items.put(name, new Item(price, quantity));
        }
    }

    public boolean removeItem(String name) {
        return items.remove(name) != null;
    }

    public void applyDiscount(int percent) {
        if (percent < 0 || percent > 50) {
            throw new IllegalArgumentException("Discount must be between 0 and 50");
        }
        this.discountPercent = percent;
    }

    public double getTotal() {
        double sum = 0;
        for (Item item : items.values()) {
            sum += item.price * item.quantity;
        }
        return sum * (100 - discountPercent) / 100.0;
    }

    public int getItemCount() {
        int count = 0;
        for (Item item : items.values()) {
            count += item.quantity;
        }
        return count;
    }


}
