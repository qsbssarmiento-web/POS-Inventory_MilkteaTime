package project.milktea_pos_inv;

import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 * POSManager handles order creation, checkout, and integration
 * with the inventory system for ingredient deduction.
 */
public class POSManager {

    // ---------------------------------------
    // 🔹 FIELDS
    // ---------------------------------------
    private final String[] ordersColumns = {"Qty", "Description", "Price", "Total"};
    private final DefaultTableModel model;
    private final List<Order> orders;

    private Inventory inventory; // Optional: linked inventory handler

    // ---------------------------------------
    // 🔹 CONSTRUCTOR
    // ---------------------------------------
    public POSManager() {
        this.model = new DefaultTableModel(ordersColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // make table read-only
            }
        };
        this.orders = new ArrayList<>();
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    // ---------------------------------------
    // 🔹 INNER CLASS: ORDER
    // ---------------------------------------
    public static class Order {
        private final String productID;
        private final String itemName;
        private int quantity;
        private final double price;

        public Order(String productID, String itemName, int quantity, double price) {
            this.productID = productID;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }

        public double getTotal() {
            return quantity * price;
        }

        public String getProductID() { return productID; }
        public String getItemName() { return itemName; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        public void increaseQuantity(int amount) { this.quantity += amount; }
        public void decreaseQuantity(int amount) { this.quantity = Math.max(0, quantity - amount); }
    }

    // ---------------------------------------
    // 🔹 ORDER MANAGEMENT
    // ---------------------------------------

    /**
     * Adds a product to the current order list.
     * If the product already exists, increase its quantity.
     */
    public void addOrder(String productID, String description, int quantity, double price) {
        if (quantity <= 0) {
            System.err.println("⚠️ Quantity must be greater than zero.");
            return;
        }

        for (Order o : orders) {
            if (o.getProductID().equals(productID)) {
                o.increaseQuantity(quantity);
                refreshTable();
                return;
            }
        }

        Order newOrder = new Order(productID, description, quantity, price);
        orders.add(newOrder);
        model.addRow(new Object[]{quantity, description, price, newOrder.getTotal()});
    }

    /**
     * Removes an order by its index.
     */
    public void removeOrder(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
            model.removeRow(index);
        } else {
            System.err.println("⚠️ Invalid order index: " + index);
        }
    }

    /**
     * Clears all current orders.
     */
    public void clearOrders() {
        orders.clear();
        model.setRowCount(0);
    }

    /**
     * Refreshes the visual table to match the current order list.
     */
    public void refreshTable() {
        model.setRowCount(0);
        for (Order o : orders) {
            model.addRow(new Object[]{
                o.getQuantity(),
                o.getItemName(),
                String.format("₱%.2f", o.getPrice()),
                String.format("₱%.2f", o.getTotal())
            });
        }
    }

    public List<Order> getOrders() { return new ArrayList<>(orders); }
    public DefaultTableModel getTableModel() { return model; }

    // ---------------------------------------
    // 🔹 TOTALS & CHECKOUT
    // ---------------------------------------

    public double getSubtotal() {
        return orders.stream().mapToDouble(Order::getTotal).sum();
    }

    public double getTax(double rate) {
        return getSubtotal() * rate;
    }

    public double getGrandTotal(double taxRate) {
        return getSubtotal() + getTax(taxRate);
    }

    /**
     * Processes checkout — deducts ingredients from inventory.
     */
    public boolean processCheckout() {
        if (orders.isEmpty()) {
            System.out.println("⚠️ No items in order.");
            return false;
        }

        if (inventory == null) {
            System.out.println("⚠️ No inventory linked. Cannot deduct ingredients.");
            return false;
        }

        System.out.println("🧾 Processing checkout...");
        for (Order order : orders) {
            for (int i = 0; i < order.getQuantity(); i++) {
                boolean success = inventory.deductIngredientsForProduct(order.getProductID());
                if (!success) {
                    System.err.println("❌ Failed to deduct ingredients for " + order.getItemName());
                    return false;
                }
            }
        }

        System.out.println("✅ Checkout successful! Total: ₱" + String.format("%.2f", getSubtotal()));
        clearOrders();
        return true;
    }

    // ---------------------------------------
    // 🔹 UTILITIES
    // ---------------------------------------

    public int getOrderCount() { return orders.size(); }
    public boolean isEmpty() { return orders.isEmpty(); }

    public void printOrderSummary() {
        System.out.println("🧾 Current Orders:");
        for (Order o : orders) {
            System.out.printf("- %s x%d = ₱%.2f%n", o.getItemName(), o.getQuantity(), o.getTotal());
        }
        System.out.printf("TOTAL: ₱%.2f%n", getSubtotal());
    }
}
