package com.procedure.service;

import java.util.List;

import com.procedure.entity.Item;

public interface ItemService {

 public List<Item> getAll();
	
	Item saveItem(Item item);
	
	public Item getItemById(int id);
	
	public void deleteItem(int id);
}
