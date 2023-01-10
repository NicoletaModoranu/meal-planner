package com.planner.mealplanner.controller;

import com.planner.mealplanner.dto.RecipeBaseDto;
import com.planner.mealplanner.dto.RecipeDTO;
import com.planner.mealplanner.mapper.ManualMapper;
import com.planner.mealplanner.model.Recipe;
import com.planner.mealplanner.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/recipe")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ManualMapper recipeMapper;

    @GetMapping("/{title}")
    public ResponseEntity<RecipeDTO> getRecipeByTitle(@PathVariable String title) {
        return new ResponseEntity<>(recipeMapper.recipeToRecipeDTO(recipeService.getRecipe(title)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> newRecipe(@RequestBody RecipeBaseDto recipeBaseDto) {

        Recipe savedRecipe = recipeService.save(recipeMapper.recipeBaseDtoToRecipe(recipeBaseDto));

        return new ResponseEntity<>(recipeMapper.recipeToRecipeDTO(savedRecipe), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RecipeDTO> updateRecipe(@RequestBody RecipeDTO recipeDTO) throws Exception {

        Recipe savedRecipe = recipeService.update(recipeMapper.recipeDtoToRecipe(recipeDTO));

        return new ResponseEntity<>(recipeMapper.recipeToRecipeDTO(savedRecipe), HttpStatus.OK);
    }
}
