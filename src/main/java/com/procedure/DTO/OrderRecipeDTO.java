package com.procedure.DTO;


import java.util.List;

import lombok.Data;

@Data
public class OrderRecipeDTO {
	
	private double amount;
	private double billamount;
	private int OrderId;
	private int RecipeId;
	private List<OrderRecipeItemDTO> orderRecipeItemDTOS;


}
