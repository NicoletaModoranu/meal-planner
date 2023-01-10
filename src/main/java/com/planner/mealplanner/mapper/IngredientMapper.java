package com.planner.mealplanner.mapper;

import com.planner.mealplanner.dto.IngredientBaseDto;
import com.planner.mealplanner.dto.IngredientDTO;
import com.planner.mealplanner.model.Ingredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDTO ingredientToIngredientDTO(Ingredient ingredient);

    Ingredient ingredientDtoToIngredient(IngredientDTO ingredientDTO);

    static Ingredient ingredientBaseDtoToIngredient(IngredientBaseDto ingredientBaseDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientBaseDto.getName());
        ingredient.setAverageWeight(ingredientBaseDto.getAverageWeight());
        ingredient.setMeasure(ingredientBaseDto.getMeasure());

        return ingredient;
    }


}
