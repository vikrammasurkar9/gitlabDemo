package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.DTO.OrderBazarDTO;
import com.procedure.DTO.OrderRecipeDTO;
import com.procedure.DTO.RecipeBazarDTO;
import com.procedure.entity.Orders;
import com.procedure.repository.OrdersRepo;
import com.procedure.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepo ordersRepo;

	@Override
	public List<Orders> getAll() {
		List<Orders> orders=ordersRepo.findAll();
		return orders;
	}

	@Override
	public Orders saveOrders(Orders orders) {
		return ordersRepo.save(orders);
	}

	@Override
	public Orders getOrdersById(int id) {
		Orders orders=ordersRepo.findById(id).orElse(null);
		return orders;
	}

	@Override
	public void deleteOrder(int id) {
		ordersRepo.deleteById(id);
	}

	@Override
	public OrderRecipeDTO calculateRecipePrice(int recipeId, int quantity) {
		
		return null;
	}

	@Override
	public List<OrderBazarDTO> GetBazarList(int orderid) {
		
		return ordersRepo.getalldata(orderid);
	}

	@Override
	public List<RecipeBazarDTO> generateRecipeBazarList(int id) {
	
		return ordersRepo.generateRecipeBazarList(id);
	}

}
