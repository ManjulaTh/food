package com.cooksys.food;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface FoodMapper {

	FoodDto toDto(Food food);
	
	Food fromDto(FoodDto dto);
	
}
