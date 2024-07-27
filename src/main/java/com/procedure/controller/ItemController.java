package com.procedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procedure.DTO.ItemDTO;
import com.procedure.DTO.UnitDTO;
import com.procedure.entity.Item;
import com.procedure.entity.Unit;
import com.procedure.service.ItemService;
import com.procedure.service.UnitService;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private UnitService unitService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	 public ResponseEntity<List<Item>> GetAllItems()
	    {
	    	List<Item> item=itemService.getAll();
	    	
			return new ResponseEntity<>(item,HttpStatus.OK);
	    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> GetItemById(@PathVariable int id)
	{
		Item item=itemService.getItemById(id);
		
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@PostMapping("/")
     public ResponseEntity<Item> saveAll(@RequestBody ItemDTO itemDTO) {
    	
    	
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setRate(itemDTO.getRate());
       
        Unit unit = unitService.getUnitById(itemDTO.getUnitid());

        item.setUnit(unit);

        Item updatedItems = itemService.saveItem(item);

        return new ResponseEntity<>(updatedItems, HttpStatus.OK);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody ItemDTO itemDTO) {

		Item existingItem = itemService.getItemById(id);

		if (existingItem == null) {
			return new ResponseEntity<>(existingItem, HttpStatus.NOT_FOUND);
		}


		// existingItem.setId(itemsDto.getId());
		existingItem.setName(itemDTO.getName());
		existingItem.setRate(itemDTO.getRate());

		Unit unit = unitService.getUnitById(itemDTO.getUnitid());
		existingItem.setUnit(unit);
		
        System.out.println(":---" + unit.getId() + "   " + unit.getName());
        
		Item updatedItem = itemService.saveItem(existingItem);

		return new ResponseEntity<>(updatedItem, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable int id)
	{
		
		itemService.deleteItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
			
	}

}
