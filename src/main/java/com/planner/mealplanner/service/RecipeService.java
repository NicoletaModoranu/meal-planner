package com.planner.mealplanner.service;

import com.planner.mealplanner.model.Ingredient;
import com.planner.mealplanner.model.Recipe;
import com.planner.mealplanner.model.RecipeIngredient;
import com.planner.mealplanner.repository.IngredientRepository;
import com.planner.mealplanner.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Recipe getRecipe(String title) {
        return recipeRepository.findByTitle(title);
    }

    public Recipe save(Recipe recipe) {
        recipe.getRecipeIngredients().forEach(recipeIngredient -> {
            Optional<Ingredient> ingredientOptional = ingredientRepository.findById(recipeIngredient.getId().getIngredientId());
            recipeIngredient.setRecipe(recipe);
            ingredientOptional.ifPresent(recipeIngredient::setIngredient);
        });

        return recipeRepository.save(recipe);
    }

    public Recipe update1(Recipe recipe) throws Exception {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipe.getRecipeId());

        if (!optionalRecipe.isPresent()) {
            throw new Exception("the recipe does not exist");
        }


        Recipe existingRecipe = optionalRecipe.get();
        //update fields
        existingRecipe.setTitle(recipe.getTitle());

        List<RecipeIngredient> updatedList = recipe.getRecipeIngredients();


        ListIterator<RecipeIngredient> iter = existingRecipe.getRecipeIngredients().listIterator();

        while (iter.hasNext()) {
            RecipeIngredient item = iter.next();
            boolean hasBeenUpdated = false;

            for (RecipeIngredient uri : updatedList) {
                if (uri.getId().getIngredientId().equals(item.getId().getIngredientId())) {
                    item.setQuantity(uri.getQuantity());
                    hasBeenUpdated = true;
                    break;
                }
            }
            if (!hasBeenUpdated) {
                iter.remove();
            }
        }

        updatedList.removeAll(existingRecipe.getRecipeIngredients());

        ListIterator<RecipeIngredient> updatedListIterator = updatedList.listIterator();

        while (updatedListIterator.hasNext()) {
            RecipeIngredient updatedRecipeINg = iter.next();

            Optional<Ingredient> ingredientOptional = ingredientRepository.findById(updatedRecipeINg.getId().getIngredientId());
            updatedRecipeINg.setRecipe(recipe);
            ingredientOptional.ifPresent(updatedRecipeINg::setIngredient);
            recipe.getRecipeIngredients().add(updatedRecipeINg);
        }
        //iterat pe lista
        //daca ingredientul exista in lista - update
        // daca ingredientul nu exista in lista - adauga

        return recipeRepository.save(existingRecipe);

        //If the item doesn't exist in List B, you should use create item action to copy the item, or if the item already exists, then you could use update item action.
    }


    public Recipe update(Recipe recipe) throws Exception {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipe.getRecipeId());

        if (!optionalRecipe.isPresent()) {
            throw new Exception("the recipe does not exist");
        }


        Recipe existingRecipe = optionalRecipe.get();
        //update fields
        existingRecipe.setTitle(recipe.getTitle());

        List<RecipeIngredient> updatedList = recipe.getRecipeIngredients();


        ListIterator<RecipeIngredient> iter = existingRecipe.getRecipeIngredients().listIterator();

        while (iter.hasNext()) {
            RecipeIngredient item = iter.next();
            boolean hasBeenUpdated = false;

            for (RecipeIngredient uri : updatedList) {
                if (uri.getId().getIngredientId().equals(item.getId().getIngredientId())) {
                    item.setQuantity(uri.getQuantity());
                    hasBeenUpdated = true;
                    break;
                }
            }
            if (!hasBeenUpdated) {
                iter.remove();
            }
        }

        updatedList.removeAll(existingRecipe.getRecipeIngredients());

        ListIterator<RecipeIngredient> updatedListIterator = updatedList.listIterator();

        while (updatedListIterator.hasNext()) {
            RecipeIngredient updatedRecipeINg = iter.next();

            Optional<Ingredient> ingredientOptional = ingredientRepository.findById(updatedRecipeINg.getId().getIngredientId());
            updatedRecipeINg.setRecipe(recipe);
            ingredientOptional.ifPresent(updatedRecipeINg::setIngredient);
            recipe.getRecipeIngredients().add(updatedRecipeINg);
        }
        //iterat pe lista
        //daca ingredientul exista in lista - update
        // daca ingredientul nu exista in lista - adauga

        return recipeRepository.save(existingRecipe);

        //If the item doesn't exist in List B, you should use create item action to copy the item, or if the item already exists, then you could use update item action.
    }
}
