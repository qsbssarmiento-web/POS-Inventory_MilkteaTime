package project.milktea_pos_inv;

import java.util.*;

/**
 * Handles product, ingredient, and recipe management for the POS inventory.
 * Responsible for stock control, product categorization, and recipe linkage.
 */
public class Inventory {

    // ---------------------------------------
    // 🔹 Fields
    // ---------------------------------------
    private final List<Products> products;
    private final List<Ingredient> ingredients;
    private final List<Recipe> recipes;

    // ---------------------------------------
    // 🔹 Constructor
    // ---------------------------------------
    public Inventory() {
        this.products = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }

    // ==========================================================
    // 🧃 PRODUCT MANAGEMENT
    // ==========================================================
    public void addProduct(Products product) {
        if (product == null) {
            System.err.println("⚠️ Cannot add null product.");
            return;
        }
        if (getProductByID(product.getItemID()) != null) {
            System.err.println("⚠️ Duplicate product ID: " + product.getItemID());
            return;
        }
        products.add(product);
        System.out.println("🟢 Product added: " + product.getName());
    }

    public boolean removeProduct(String productID) {
        if (productID == null) return false;
        boolean removed = products.removeIf(p -> p.getItemID().equalsIgnoreCase(productID));
        if (removed) {
            System.out.println("🟡 Product removed: " + productID);
        } else {
            System.err.println("⚠️ Product not found: " + productID);
        }
        return removed;
    }

    public Products getProductByID(String productID) {
        if (productID == null) return null;
        for (Products p : products) {
            if (p.getItemID().equalsIgnoreCase(productID)) return p;
        }
        return null;
    }

    public List<Products> getAllProducts() {
        return new ArrayList<>(products); // return a safe copy
    }

    public List<Products> getProductsByCategory(String category) {
        List<Products> result = new ArrayList<>();
        if (category == null) return result;

        for (Products p : products) {
            if (p.getCategory() != null && p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public Set<String> getAllCategories() {
        Set<String> categories = new HashSet<>();
        for (Products p : products) {
            if (p.getCategory() != null && !p.getCategory().isEmpty()) {
                categories.add(p.getCategory());
            }
        }
        return categories;
    }

    public void updateProductStock(String productID, int newQuantity) {
        Products product = getProductByID(productID);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("🔄 Product stock updated: " + product.getName() + " → " + newQuantity);
        } else {
            System.err.println("⚠️ Product not found: " + productID);
        }
    }

    // ==========================================================
    // 🧂 INGREDIENT MANAGEMENT
    // ==========================================================
    public void addIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            System.err.println("⚠️ Cannot add null ingredient.");
            return;
        }
        if (getIngredientByID(ingredient.getItemID()) != null) {
            System.err.println("⚠️ Duplicate ingredient ID: " + ingredient.getItemID());
            return;
        }
        ingredients.add(ingredient);
        System.out.println("🟢 Ingredient added: " + ingredient.getName());
    }

    public boolean removeIngredient(String ingredientID) {
        if (ingredientID == null) return false;
        boolean removed = ingredients.removeIf(i -> i.getItemID().equalsIgnoreCase(ingredientID));
        if (removed) {
            System.out.println("🟡 Ingredient removed: " + ingredientID);
        } else {
            System.err.println("⚠️ Ingredient not found: " + ingredientID);
        }
        return removed;
    }

    public Ingredient getIngredientByID(String ingredientID) {
        if (ingredientID == null) return null;
        for (Ingredient i : ingredients) {
            if (i.getItemID().equalsIgnoreCase(ingredientID)) return i;
        }
        return null;
    }

    public List<Ingredient> getAllIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void restockIngredient(String ingredientID, int amount) {
        Ingredient ingredient = getIngredientByID(ingredientID);
        if (ingredient != null) {
            ingredient.addStock(amount);
            System.out.println("🟢 Restocked " + ingredient.getName() + " by " + amount
                    + " units. New total: " + ingredient.getQuantity());
        } else {
            System.err.println("⚠️ Cannot restock. Ingredient not found: " + ingredientID);
        }
    }

    // ==========================================================
    // 🧾 RECIPE MANAGEMENT
    // ==========================================================
    public void addRecipe(Recipe recipe) {
        if (recipe == null) {
            System.err.println("⚠️ Cannot add null recipe.");
            return;
        }
        if (getRecipeByProductID(recipe.getProductID()) != null) {
            System.err.println("⚠️ Recipe already exists for product: " + recipe.getProductID());
            return;
        }
        recipes.add(recipe);
        System.out.println("🟢 Recipe added for product: " + recipe.getProductID());
    }

    public Recipe getRecipeByProductID(String productID) {
        if (productID == null) return null;
        for (Recipe r : recipes) {
            if (r.getProductID().equalsIgnoreCase(productID)) return r;
        }
        return null;
    }

    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipes);
    }

    // ==========================================================
    // 🍵 STOCK DEDUCTION WHEN SELLING A PRODUCT
    // ==========================================================
    public boolean deductIngredientsForProduct(String productID) {
        Recipe recipe = getRecipeByProductID(productID);

        if (recipe == null) {
            System.err.println("❌ No recipe found for product ID: " + productID);
            return false;
        }

        // ✅ Check availability first
        for (Map.Entry<Ingredient, Double> entry : recipe.getIngredientsUsed().entrySet()) {
            Ingredient required = entry.getKey();
            double amountNeeded = entry.getValue();

            Ingredient stored = getIngredientByID(required.getItemID());
            if (stored == null) {
                System.err.println("⚠️ Missing ingredient: " + required.getName());
                return false;
            }

            if (stored.getQuantity() < amountNeeded) {
                System.err.println("⚠️ Not enough " + stored.getName() + ": Need " + amountNeeded
                        + ", Have " + stored.getQuantity());
                return false;
            }
        }

        // ✅ Deduct if all available
        for (Map.Entry<Ingredient, Double> entry : recipe.getIngredientsUsed().entrySet()) {
            Ingredient required = entry.getKey();
            double amountNeeded = entry.getValue();

            Ingredient stored = getIngredientByID(required.getItemID());
            if (stored != null) {
                stored.deductStock((int) amountNeeded);
                System.out.println("🟢 Deducted " + amountNeeded + " units of " + stored.getName()
                        + ". Remaining: " + stored.getQuantity());
            }
        }

        System.out.println("✅ All ingredients successfully deducted for product: " + productID);
        return true;
    }

    // ==========================================================
    // 📋 REPORT / INFO
    // ==========================================================
    public void printInventorySummary() {
        System.out.println("\n📦 INVENTORY SUMMARY ----------------");
        System.out.println("Products: " + products.size());
        System.out.println("Ingredients: " + ingredients.size());
        System.out.println("Recipes: " + recipes.size());
        System.out.println("-----------------------------------");
    }
}
