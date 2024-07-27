package com.procedure.service;

import java.util.List;

import com.procedure.DTO.OrderBazarDTO;
import com.procedure.DTO.OrderRecipeDTO;
import com.procedure.DTO.RecipeBazarDTO;
import com.procedure.entity.Orders;

public interface OrdersService {
	
    public List<Orders> getAll();
	
	public Orders saveOrders(Orders orders);
	
	public Orders getOrdersById(int id);
	
	public void deleteOrder(int id);
	
	public OrderRecipeDTO calculateRecipePrice(int recipeId, int quantity);
	
	public List<OrderBazarDTO> GetBazarList(int orderid);
	
	public List<RecipeBazarDTO>generateRecipeBazarList(int id);

}
