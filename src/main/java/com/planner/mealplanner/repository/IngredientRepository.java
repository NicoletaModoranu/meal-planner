package com.planner.mealplanner.repository;

import com.planner.mealplanner.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    Optional<Ingredient> findByIngredientId(Long id);
}
