package com.procedure.service;

import java.util.List;

import com.procedure.entity.OrderRecipe;

public interface OrderRecipeService {
	
public List<OrderRecipe> getAll();
	
	public OrderRecipe saveOrderRecipe(OrderRecipe orderRecipe);
	
	public OrderRecipe getOrderRecipeById(int id);
	
	public void deleteOrderRecipe(int id);
	
	public int calculateRecipePrice(int recipeId, int quantity);


}
