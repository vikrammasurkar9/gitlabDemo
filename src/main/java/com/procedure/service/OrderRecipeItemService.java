package com.procedure.service;

import java.util.List;

import com.procedure.entity.OrderRecipeItem;

public interface OrderRecipeItemService {
	
public List<OrderRecipeItem> getAll();
	
	public OrderRecipeItem saveOrderRecipeItem(OrderRecipeItem orderRecipeItem);
	
	public OrderRecipeItem getOrderRecipeItemById(int id);
	
	public void deleteOrderRecipeItem(int id);

}
