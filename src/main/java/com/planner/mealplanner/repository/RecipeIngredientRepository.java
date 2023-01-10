package com.planner.mealplanner.repository;

import com.planner.mealplanner.model.Recipe;
import com.planner.mealplanner.model.RecipeIngredientPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<Recipe, RecipeIngredientPK> {
}
