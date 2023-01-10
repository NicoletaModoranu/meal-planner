package com.planner.mealplanner.dto;

import com.planner.mealplanner.model.Measure;

public class IngredientBaseDto {

    private String name;
    private Integer averageWeight;
    private Measure measure;

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
}
