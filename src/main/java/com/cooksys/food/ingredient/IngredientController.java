package com.cooksys.food.ingredient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredient")
public class IngredientController {

	private IngredientMapper ingredientMapper;
	private IngredientService ingredientService;
	
	public IngredientController(IngredientMapper ingredientMapper, IngredientService ingredientService) {
		super();
		this.ingredientMapper = ingredientMapper;
		this.ingredientService = ingredientService;
	}

	@PostMapping
	public void createIngredient(@RequestBody IngredientDto dto) {
		ingredientService.create(ingredientMapper.fromDto(dto));
	}
	
}
