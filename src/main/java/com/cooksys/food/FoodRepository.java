package com.cooksys.food;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class FoodRepository {

	private EntityManager em;
	
	public FoodRepository(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Food> findAll() {
		return em.createQuery("FROM Food").getResultList();
	}
	
	@Transactional
	public void save(Food food) {
		em.persist(food);
	}

	public Food findById(Integer foodId) {
		return em.find(Food.class, foodId);
	}
	
	@Transactional
	public void update(Food food) {
		em.merge(food);
	}

}
