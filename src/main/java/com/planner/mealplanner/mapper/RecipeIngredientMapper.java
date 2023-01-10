package com.planner.mealplanner.mapper;

import com.planner.mealplanner.dto.RecipeIngredientDTO;
import com.planner.mealplanner.model.Ingredient;
import com.planner.mealplanner.model.Recipe;
import com.planner.mealplanner.model.RecipeIngredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RecipeIngredientPKMapper.class})
public interface RecipeIngredientMapper {


    RecipeIngredientDTO recipeIngredientToRecipeIngredientDTO(RecipeIngredient recipeIngredient);

    RecipeIngredient recipeIngredientDtoToRecipeIngredient(RecipeIngredientDTO recipRecipeIngredientDTO);

//
//    public static RecipeIngredient recipeIngredientDtoToRecipeIngredient(RecipeIngredientDTO recipRecipeIngredientDTO) {
//        if ( recipRecipeIngredientDTO == null ) {
//            return null;
//        }
//
//        Recipe recipe = null;
//        Ingredient ingredient = null;
//
//        recipe = recipeDTOToRecipe( recipRecipeIngredientDTO.getRecipe() );
//        ingredient = ingredientDTOToIngredient( recipRecipeIngredientDTO.getIngredient() );
//
//        RecipeIngredient recipeIngredient = new RecipeIngredient( recipe, ingredient );
//
//        recipeIngredient.setId( recipeIngredientPKDtoToRecipeIngredientPK( recipRecipeIngredientDTO.getId() ) );
//        recipeIngredient.setQuantity( recipRecipeIngredientDTO.getQuantity() );
//
//        return recipeIngredient;
//    }

    List<RecipeIngredient> toRecipeIngredientList(List<RecipeIngredientDTO> list);

    List<RecipeIngredientDTO> toRecipeIngredientDTOList(List<RecipeIngredient> list);
}
