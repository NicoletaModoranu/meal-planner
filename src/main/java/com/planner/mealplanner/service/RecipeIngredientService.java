package com.planner.mealplanner.service;

import com.planner.mealplanner.model.RecipeIngredient;
import com.planner.mealplanner.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    public RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    public void saveIngredients(List<RecipeIngredient> recipeIngredientList){

    }
}
