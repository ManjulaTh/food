package com.cooksys.food.ingredient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	public List<IngredientDto> findAll(@RequestParam(name="spicy", required=false) Boolean spicy) {
		if(spicy != null) {
			return ingredientService.findBySpiceLevel(spicy).stream().map(ingredientMapper::toDto).collect(Collectors.toList());
		} else {
			return ingredientService.findAll().stream().map(ingredientMapper::toDto).collect(Collectors.toList());
		}
	}
	
	@PostMapping("/searchByExample")
	public List<IngredientDto> findAllLike(@RequestBody IngredientDto example) {
		return ingredientService.findAllLike(ingredientMapper.fromDto(example)).stream().map(ingredientMapper::toDto).collect(Collectors.toList());
		
	}
	
}
