package com.cooksys.food.ingredient;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.cooksys.food.Food;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Boolean spicy;
	
	@ManyToMany
	private List<Food> foods;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getSpicy() {
		return spicy;
	}

	public void setSpicy(Boolean spicy) {
		this.spicy = spicy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
