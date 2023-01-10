package com.planner.mealplanner.mapper;

import com.planner.mealplanner.dto.*;
import com.planner.mealplanner.model.Ingredient;
import com.planner.mealplanner.model.Recipe;
import com.planner.mealplanner.model.RecipeIngredient;
import com.planner.mealplanner.model.RecipeIngredientPK;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManualMapper {


    public static RecipeDTO recipeToRecipeDTO(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setTitle(recipe.getTitle());
        recipeDTO.setRecipeIngredients(toRecipeIngredientDTOList(recipe.getRecipeIngredients()));
        recipeDTO.setRecipeId(recipe.getRecipeId());

        return recipeDTO;
    }


    public static Recipe recipeDtoToRecipe(RecipeDTO recipeDTO) {
        if (recipeDTO == null) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setRecipeId(recipeDTO.getRecipeId());
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setRecipeIngredients(toRecipeIngredientList(recipeDTO.getRecipeIngredients()));

        return recipe;
    }


    public static Recipe recipeBaseDtoToRecipe(RecipeBaseDto recipeBaseDto) {
        if (recipeBaseDto == null) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setTitle(recipeBaseDto.getTitle());
        recipe.setRecipeIngredients(toRecipeIngredientList(recipeBaseDto.getRecipeIngredients()));

        return recipe;
    }

    public static RecipeIngredientDTO recipeIngredientToRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) {
            return null;
        }

        RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();

        recipeIngredientDTO.setId(recipeIngredientPKToRecipeIngredientPKDto(recipeIngredient.getId()));
       // recipeIngredientDTO.setRecipe(recipeToRecipeDTO(recipeIngredient.getRecipe()));
        recipeIngredientDTO.setIngredient(ingredientToIngredientDTO(recipeIngredient.getIngredient()));
        recipeIngredientDTO.setQuantity(recipeIngredient.getQuantity());

        return recipeIngredientDTO;
    }

    public static RecipeIngredient recipeIngredientDtoToRecipeIngredient(RecipeIngredientDTO recipRecipeIngredientDTO) {
        if (recipRecipeIngredientDTO == null) {
            return null;
        }

        RecipeIngredient recipeIngredient = new RecipeIngredient();

        recipeIngredient.setId(recipeIngredientPKDtoToRecipeIngredientPK(recipRecipeIngredientDTO.getId()));
        recipeIngredient.setRecipe(recipeDTOToRecipe(recipRecipeIngredientDTO.getRecipe()));
        recipeIngredient.setIngredient(ingredientDTOToIngredient(recipRecipeIngredientDTO.getIngredient()));
        recipeIngredient.setQuantity(recipRecipeIngredientDTO.getQuantity());

        return recipeIngredient;
    }

    public static List<RecipeIngredient> toRecipeIngredientList(List<RecipeIngredientDTO> list) {
        if (list == null) {
            return null;
        }

        List<RecipeIngredient> list1 = new ArrayList<RecipeIngredient>(list.size());
        for (RecipeIngredientDTO recipeIngredientDTO : list) {
            list1.add(recipeIngredientDtoToRecipeIngredient(recipeIngredientDTO));
        }

        return list1;
    }

    public static List<RecipeIngredientDTO> toRecipeIngredientDTOList(List<RecipeIngredient> list) {
        if (list == null) {
            return null;
        }

        List<RecipeIngredientDTO> list1 = new ArrayList<RecipeIngredientDTO>(list.size());
        for (RecipeIngredient recipeIngredient : list) {
            list1.add(recipeIngredientToRecipeIngredientDTO(recipeIngredient));
        }

        return list1;
    }

    public static RecipeIngredientPKDto recipeIngredientPKToRecipeIngredientPKDto(RecipeIngredientPK recipeIngredientPK) {
        if (recipeIngredientPK == null) {
            return null;
        }

        RecipeIngredientPKDto recipeIngredientPKDto = new RecipeIngredientPKDto();

        recipeIngredientPKDto.setRecipeId(recipeIngredientPK.getRecipeId());
        recipeIngredientPKDto.setIngredientId(recipeIngredientPK.getIngredientId());

        return recipeIngredientPKDto;
    }


    public static  RecipeIngredientPK recipeIngredientPKDtoToRecipeIngredientPK(RecipeIngredientPKDto recipeIngredientPKDto) {
        if (recipeIngredientPKDto == null) {
            return null;
        }

        RecipeIngredientPK recipeIngredientPK = new RecipeIngredientPK();

        recipeIngredientPK.setRecipeId(recipeIngredientPKDto.getRecipeId());
        recipeIngredientPK.setIngredientId(recipeIngredientPKDto.getIngredientId());

        return recipeIngredientPK;
    }

    public static Recipe recipeDTOToRecipe(RecipeDTO recipeDTO) {
        if (recipeDTO == null) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setRecipeId(recipeDTO.getRecipeId());
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setRecipeIngredients(toRecipeIngredientList(recipeDTO.getRecipeIngredients()));

        return recipe;
    }

    public static Ingredient ingredientDTOToIngredient(IngredientDTO ingredientDTO) {
        if (ingredientDTO == null) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientId(ingredientDTO.getIngredientId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAverageWeight(ingredientDTO.getAverageWeight());
        ingredient.setMeasure(ingredientDTO.getMeasure());

        return ingredient;
    }

    public static IngredientDTO ingredientToIngredientDTO(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        IngredientDTO ingredientDTO = new IngredientDTO();

        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setAverageWeight(ingredient.getAverageWeight());
        ingredientDTO.setMeasure(ingredient.getMeasure());
        ingredientDTO.setIngredientId(ingredient.getIngredientId());

        return ingredientDTO;
    }

    public static Ingredient ingredientDtoToIngredient(IngredientDTO ingredientDTO) {
        if (ingredientDTO == null) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientId(ingredientDTO.getIngredientId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAverageWeight(ingredientDTO.getAverageWeight());
        ingredient.setMeasure(ingredientDTO.getMeasure());

        return ingredient;
    }
}
