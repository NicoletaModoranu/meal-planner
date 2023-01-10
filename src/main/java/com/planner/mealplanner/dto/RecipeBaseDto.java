package com.planner.mealplanner.dto;

import java.util.List;

public class RecipeBaseDto {

    private String title;
    private List<RecipeIngredientDTO> recipeIngredients;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeIngredientDTO> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientDTO> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}
