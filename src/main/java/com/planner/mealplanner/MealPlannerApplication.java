package com.planner.mealplanner;

import com.planner.mealplanner.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MealPlannerApplication {

	@Autowired
	UserController userService;
	public static void main(String[] args) {
		SpringApplication.run(MealPlannerApplication.class, args);
	}


}
