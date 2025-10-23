package project.milktea_pos_inv;

public class Ingredient extends InventoryItem {
    
    private String type;          // e.g., "Solid", "Liquid", "Topping", "Flavor"
    private String measurement;   // e.g., "ml", "grams", "pcs"

    // Constructors
    public Ingredient() {}

    public Ingredient(String itemID, String name, int quantity, String category, String unit, String type, String measurement) {
        super(itemID, name, quantity, category, unit);
        this.type = type;
        this.measurement = measurement;
    }

    public Ingredient(String name, String type, String measurement) {
        this.name = name;
        this.type = type;
        this.measurement = measurement;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getMeasurement() {
        return measurement;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public boolean isLowStock() {
        return quantity < 10; // default threshold, adjustable
    }
}
