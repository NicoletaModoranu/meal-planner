package com.planner.mealplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MealPlannerApplication {

	@Autowired
	Service service;
	public static void main(String[] args) {
		SpringApplication.run(MealPlannerApplication.class, args);
	}


}
