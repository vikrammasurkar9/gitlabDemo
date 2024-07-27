package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.OrderRecipeItem;
import com.procedure.repository.OrderRecipeItemRepo;
import com.procedure.service.OrderRecipeItemService;

@Service
public class OrderRecipeItemServiceImpl implements OrderRecipeItemService {

	@Autowired
	private OrderRecipeItemRepo orderRecipeItemRepo;

	
	@Override
	public List<OrderRecipeItem> getAll() {
		List<OrderRecipeItem> orderRecipeItem=orderRecipeItemRepo.findAll();
		return orderRecipeItem;
	}

	@Override
	public OrderRecipeItem saveOrderRecipeItem(OrderRecipeItem orderRecipeItem) {
		return orderRecipeItemRepo.save(orderRecipeItem);
	}

	@Override
	public OrderRecipeItem getOrderRecipeItemById(int id) {
		OrderRecipeItem orderRecipeItem=orderRecipeItemRepo.findById(id).orElse(null);
		return orderRecipeItem;
	}

	@Override
	public void deleteOrderRecipeItem(int id) {
		orderRecipeItemRepo.deleteById(id);

	}

}
