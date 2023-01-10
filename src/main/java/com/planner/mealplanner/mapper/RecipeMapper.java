package com.planner.mealplanner.mapper;

import com.planner.mealplanner.dto.IngredientBaseDto;
import com.planner.mealplanner.dto.IngredientDTO;
import com.planner.mealplanner.dto.RecipeBaseDto;
import com.planner.mealplanner.dto.RecipeDTO;
import com.planner.mealplanner.model.Ingredient;
import com.planner.mealplanner.model.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RecipeIngredientMapper.class, IngredientMapper.class})
public interface RecipeMapper {

    RecipeDTO recipeToRecipeDTO(Recipe recipe);

    Recipe recipeDtoToRecipe(RecipeDTO recipeDTO);

    Recipe recipeBaseDtoToRecipe(RecipeBaseDto recipeBaseDto);
}
