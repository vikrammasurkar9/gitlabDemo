package com.procedure.DTO;

import com.procedure.entity.Item;
import com.procedure.entity.Recipes;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class RecipeItemDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quantity;

	private int recipesid;

	private int itemid;

	
	
}
