package com.cooksys.food.ingredient;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface IngredientMapper {

	Ingredient fromDto(IngredientDto dto);
	
	IngredientDto toDto(Ingredient ingredient);
	
}
