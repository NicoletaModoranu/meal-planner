package com.planner.mealplanner.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Builder
@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long recipeId;

    @Column(name = "title")
    private String title;

    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeId, recipe.recipeId) && Objects.equals(title, recipe.title) && Objects.equals(recipeIngredients, recipe.recipeIngredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, title, recipeIngredients);
    }

    public void addRecipeIngredient(Ingredient tag, Double quantity) {
        RecipeIngredient recipeIngredient = new RecipeIngredient(this, tag);
        recipeIngredient.setQuantity(quantity);
        recipeIngredients.add(recipeIngredient);
    }

    public void removeIngredient(Ingredient tag) {
        for (Iterator<RecipeIngredient> iterator = recipeIngredients.iterator();
             iterator.hasNext(); ) {
            RecipeIngredient postTag = iterator.next();

            if (postTag.getRecipe().equals(this) &&
                    postTag.getIngredient().equals(tag)) {
                iterator.remove();
                postTag.setRecipe(null);
                postTag.setIngredient(null);
            }
        }
    }

    public Recipe() {

    }
}
