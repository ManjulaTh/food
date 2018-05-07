package com.cooksys.food;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.food.ingredient.Ingredient;
import com.cooksys.food.ingredient.IngredientRepository;

@Service
public class FoodService {

	private FoodRepository foodRepository;
	private IngredientRepository ingredientRepository;

	public FoodService(FoodRepository foodRepository, IngredientRepository ingredientRepository) {
		super();
		this.foodRepository = foodRepository;
		this.ingredientRepository = ingredientRepository;
	}

	public List<Food> getAllFood() {
		return foodRepository.findAll();
	}

	public void save(Food food) {
		foodRepository.save(food);
	}

	@Transactional
	public void addIngredient(Integer foodId, Integer ingredientId) {
		foodRepository.findById(foodId).getIngredients().add(ingredientRepository.findById(ingredientId));
	}

	public List<Ingredient> getIngredients(Integer foodId) {
		return foodRepository.findById(foodId).getIngredients();
	}

	
	
}
