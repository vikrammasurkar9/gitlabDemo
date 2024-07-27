package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.OrderRecipe;
import com.procedure.entity.Orders;
import com.procedure.entity.RecipeItem;
import com.procedure.repository.OrderRecipeRepo;
import com.procedure.repository.OrdersRepo;
import com.procedure.service.OrderRecipeService;

@Service
public class OrderRecipeServiceImpl implements OrderRecipeService {


	@Autowired
	private OrderRecipeRepo orderRecipeRepo;

	@Override
	public List<OrderRecipe> getAll() {
		List<OrderRecipe> orderRecipe=orderRecipeRepo.findAll();
		return orderRecipe;
	}

	@Override
	public OrderRecipe saveOrderRecipe(OrderRecipe orderRecipe) {
		return orderRecipeRepo.save(orderRecipe);
	}

	@Override
	public OrderRecipe getOrderRecipeById(int id) {
		OrderRecipe orderRecipe=orderRecipeRepo.findById(id).orElse(null);
		return orderRecipe;
	}

	@Override
	public void deleteOrderRecipe(int id) {
		
		orderRecipeRepo.deleteById(id);
	}

	@Override
	public int calculateRecipePrice(int recipeId, int quantity) {
		
		return 0;
	}
	


}
