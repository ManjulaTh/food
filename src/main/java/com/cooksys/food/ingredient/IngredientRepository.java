package com.cooksys.food.ingredient;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepository {

	private EntityManager em;

	public IngredientRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Transactional
	public void create(Ingredient ingredient) {
		em.persist(ingredient);
	}

	public Ingredient findById(Integer ingredientId) {
		return em.find(Ingredient.class, ingredientId);
	}
	
	
	
}
