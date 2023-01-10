package com.planner.mealplanner.controller;

import com.planner.mealplanner.dto.IngredientBaseDto;
import com.planner.mealplanner.dto.IngredientDTO;
import com.planner.mealplanner.mapper.IngredientMapper;
import com.planner.mealplanner.model.Ingredient;
import com.planner.mealplanner.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ingredient")
@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    IngredientMapper ingredientMapper;

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> all() {
        return new ResponseEntity<>(ingredientService.getAllIngredients().stream().map(ingredient -> ingredientMapper.ingredientToIngredientDTO(ingredient)).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> newIngredient(@RequestBody IngredientBaseDto userDto) {
        Ingredient savedIngredient = ingredientService.save(IngredientMapper.ingredientBaseDtoToIngredient(userDto));
        return new ResponseEntity<>(ingredientMapper.ingredientToIngredientDTO(savedIngredient), HttpStatus.OK);
    }

}
