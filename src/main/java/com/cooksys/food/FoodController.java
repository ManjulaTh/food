package com.cooksys.food;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.food.ingredient.IngredientDto;
import com.cooksys.food.ingredient.IngredientMapper;

@RestController
@RequestMapping("food")
public class FoodController {
	
	private FoodMapper foodMapper;
	private FoodService foodService;
	private IngredientMapper ingredientMapper;
	
	public FoodController(FoodMapper foodMapper, FoodService foodService, IngredientMapper ingredientMapper) {
		super();
		this.foodMapper = foodMapper;
		this.foodService = foodService;
		this.ingredientMapper = ingredientMapper;
	}

	@GetMapping
	private List<FoodDto> getFood() {
		return foodService.getAllFood().stream().map(foodMapper::toDto).collect(Collectors.toList());
	}
	
	@PostMapping
	private void createFood(@RequestBody FoodDto dto) {
		foodService.save(foodMapper.fromDto(dto));
	}
	
	@PostMapping("{id}/ingredient/{ingredientId}")
	private void addIngredient(@PathVariable("id") Integer foodId, @PathVariable("ingredientId") Integer ingredientId) {
		foodService.addIngredient(foodId, ingredientId);
	}

	@GetMapping("{id}/ingredient")
	private List<IngredientDto> getIngredients(@PathVariable("id") Integer foodId) {
		return foodService.getIngredients(foodId).stream().map(ingredientMapper::toDto).collect(Collectors.toList());
	}
	
	@PutMapping("{id}")
	private void updateFood(@PathVariable("id") Integer updateId, @RequestBody FoodDto food) {
		foodService.update(updateId, foodMapper.fromDto(food));
	}
	
}
