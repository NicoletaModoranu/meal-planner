package com.planner.mealplanner.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Ingredient")
@Table(name = "ingredient")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ingredient {

    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(name = "name")
    @NaturalId
    private String name;

    @Column(name = "average_weight")
    private Integer averageWeight;

    @OneToMany(
            mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RecipeIngredient> recipes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Measure measure;


    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(Integer averageWeight) {
        this.averageWeight = averageWeight;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public List<RecipeIngredient> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeIngredient> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredientId, that.ingredientId) && Objects.equals(name, that.name) && Objects.equals(averageWeight, that.averageWeight) && measure == that.measure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, name, averageWeight, measure);
    }
}
