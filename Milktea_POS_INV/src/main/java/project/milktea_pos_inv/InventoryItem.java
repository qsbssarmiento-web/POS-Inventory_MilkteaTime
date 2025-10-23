package project.milktea_pos_inv;

public class InventoryItem {

    protected String itemID;
    protected String name;
    protected int quantity;
    protected String category;   // e.g. "MilkTea", "Frappe", "Pastry"
    protected String unit;       // e.g. "pcs", "ml", "pack", "kg"
    
    protected String imagePath = null;

    public InventoryItem() {}

    public InventoryItem(String itemID, String name, int quantity, String category, String unit) {
        this.itemID = itemID;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.unit = unit;
    }
    
    public InventoryItem(String itemID, String name, int quantity, String category, String unit, String imagePath) {
        this.itemID = itemID;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.unit = unit;
    }

    // Getters
    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getUnit() {
        return unit;
    }
    
    public String getImagePath() {
        return imagePath;
    }

    // Setters
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Utility methods
    public void addStock(int amount) {
        this.quantity += amount;
    }

    public Boolean deductStock(int amount) {
        if (this.quantity >= amount) {
            this.quantity -= amount;
            return true;

        } else {
            return false;

        }
    }

    public boolean isLowStock(int threshold) {
        return this.quantity <= threshold;
    }
}
