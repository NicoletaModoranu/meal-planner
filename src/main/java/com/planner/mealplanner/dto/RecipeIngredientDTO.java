package com.planner.mealplanner.dto;

public class RecipeIngredientDTO {

    private RecipeIngredientPKDto id;

    private RecipeDTO recipe;

    private IngredientDTO ingredient;

    private Double quantity;

    public RecipeIngredientPKDto getId() {
        return id;
    }

    public void setId(RecipeIngredientPKDto id) {
        this.id = id;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }

    public IngredientDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDTO ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
