package com.cooksys.food.ingredient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

	List<Ingredient> findAllBySpicy(Boolean spicy);

}
