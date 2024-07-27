package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.Item;
import com.procedure.repository.ItemRepo;
import com.procedure.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public List<Item> getAll() {
		List<Item> item=itemRepo.findAll();
		return item;
	}

	@Override
	public Item saveItem(Item item) {
		
		return itemRepo.save(item);
	}

	@Override
	public Item getItemById(int id) {
		
		return itemRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteItem(int id) {
	
		itemRepo.deleteById(id);
	}
}
