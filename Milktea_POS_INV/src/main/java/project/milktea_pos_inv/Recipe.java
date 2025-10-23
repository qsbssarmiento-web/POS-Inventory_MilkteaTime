package project.milktea_pos_inv;

import java.util.HashMap;
import java.util.Map;

public class Recipe {

    private String productID; // Link to the product
    private Map<Ingredient, Double> ingredientsUsed; // Ingredient and amount needed

    // Constructor
    public Recipe(String productID) {
        this.productID = productID;
        this.ingredientsUsed = new HashMap<>();
    }

    // Getters
    public String getProductID() {
        return productID;
    }

    public Map<Ingredient, Double> getIngredientsUsed() {
        return ingredientsUsed;
    }

    // Add ingredient with specific quantity
    public void addIngredient(Ingredient ingredient, double amountUsed) {
        ingredientsUsed.put(ingredient, amountUsed);
    }

    // Remove ingredient from recipe
    public void removeIngredient(Ingredient ingredient) {
        ingredientsUsed.remove(ingredient);
    }

    // Check if recipe contains a specific ingredient
    public boolean containsIngredient(Ingredient ingredient) {
        return ingredientsUsed.containsKey(ingredient);
    }

    // Get the amount of a specific ingredient used
    public double getIngredientAmount(Ingredient ingredient) {
        return ingredientsUsed.getOrDefault(ingredient, 0.0);
    }

    // Display recipe details
    public void printRecipe() {
        System.out.println("Recipe for Product ID: " + productID);
        for (Map.Entry<Ingredient, Double> entry : ingredientsUsed.entrySet()) {
            Ingredient ing = entry.getKey();
            double amount = entry.getValue();
            System.out.println("- " + ing.getName() + " : " + amount + " " + ing.getMeasurement());
        }
    }
}
