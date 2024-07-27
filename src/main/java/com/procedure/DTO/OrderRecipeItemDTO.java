package com.procedure.DTO;

import lombok.Data;

@Data
public class OrderRecipeItemDTO {

	private double quantity;
	private double rate;
	private double amount;
	private int OrderRecipeId;
	private int ItemId;
}
