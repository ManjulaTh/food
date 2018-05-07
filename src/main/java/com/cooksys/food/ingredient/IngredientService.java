package com.cooksys.food.ingredient;

import org.springframework.stereotype.Service;

@Service
public class IngredientService {

	private IngredientRepository ingredientRepository;

	public IngredientService(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	public void create(Ingredient ingredient) {
		ingredientRepository.create(ingredient);
		
	}

	
	
}
