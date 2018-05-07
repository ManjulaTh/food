package com.cooksys.food.ingredient;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

	private IngredientRepository ingredientRepository;

	public IngredientService(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	public void create(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public List<Ingredient> findBySpiceLevel(Boolean spicy) {
		return ingredientRepository.findAllBySpicy(spicy);
	}

	public Ingredient findBy(Integer id) {
		return ingredientRepository.findById(id).get();
		
	}

	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}
	
	public List<Ingredient> findAllLike(Ingredient example) {
		return ingredientRepository.findAll(Example.of(example));
	}
	
	
}
