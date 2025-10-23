package project.milktea_pos_inv;

import java.util.List;

public class Products extends InventoryItem {
    private double price;
    private boolean available;   // for marking “Out of Stock” or hidden items
    private List<String> ingredients;  // optional: list of ingredients (if tied to inventory deduction)
    
    private String category;  // e.g., "Milktea", "Frappe", "Pastry"

    // Constructors
    public Products() {}   

    public Products(String itemID, String name, double price, String category, int quantity) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getters
    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
    
    public String getCategory() {
        return category;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    // Utility
    public double computeSubtotal(int qty) {
        return price * qty;
    }
}
