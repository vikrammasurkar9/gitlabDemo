package com.procedure.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class RecipesDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeid;
	private String name;
	private long quantity;
	private String description;
	
	
	
}
