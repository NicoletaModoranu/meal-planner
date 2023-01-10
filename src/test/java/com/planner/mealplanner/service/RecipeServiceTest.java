package com.planner.mealplanner.service;

import com.planner.mealplanner.model.Ingredient;
import com.planner.mealplanner.model.Recipe;
import com.planner.mealplanner.model.RecipeIngredient;
import com.planner.mealplanner.repository.IngredientRepository;
import com.planner.mealplanner.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {


    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private RecipeService recipeService;

    @BeforeEach
    void initService() {
        recipeRepository = mock(RecipeRepository.class);
        ingredientRepository = mock(IngredientRepository.class);
        recipeService = new RecipeService(recipeRepository, ingredientRepository);
    }

    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }


    @Test
    public void update_recipe_1() {

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(getExistingRecipe()));

    }


    private Recipe getExistingRecipe() {
        Recipe recipe = new Recipe();
        recipe.setTitle("Scrambled eggs");
        recipe.setRecipeId(1L);

        Ingredient egg = new Ingredient();
        egg.setIngredientId(1L);
        egg.setName("egg");

        Ingredient mushroom = new Ingredient();
        mushroom.setIngredientId(2L);
        mushroom.setName("mushoom");

        Ingredient bacon = new Ingredient();
        bacon.setIngredientId(3L);
        bacon.setName("bacon");

        RecipeIngredient recipeIngredient1 = new RecipeIngredient();
        recipeIngredient1.setIngredient(egg);
        recipeIngredient1.setQuantity(3.0);
        recipeIngredient1.setRecipe(recipe);

        RecipeIngredient recipeIngredient2 = new RecipeIngredient();
        recipeIngredient2.setIngredient(mushroom);
        recipeIngredient2.setQuantity(1.0);
        recipeIngredient2.setRecipe(recipe);

        RecipeIngredient recipeIngredient3 = new RecipeIngredient();
        recipeIngredient3.setIngredient(bacon);
        recipeIngredient3.setQuantity(5.0);
        recipeIngredient3.setRecipe(recipe);

        recipe.setRecipeIngredients(Arrays.asList(recipeIngredient1, recipeIngredient2, recipeIngredient3));

        return recipe;
    }
}
