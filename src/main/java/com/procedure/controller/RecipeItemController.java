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

import com.procedure.DTO.RecipeItemDTO;
import com.procedure.entity.Item;
import com.procedure.entity.RecipeItem;
import com.procedure.entity.Recipes;
import com.procedure.service.ItemService;
import com.procedure.service.RecipeItemService;
import com.procedure.service.RecipesService;

@CrossOrigin
@RestController
@RequestMapping("/recipeitem")
public class RecipeItemController {
	
	@Autowired
	private RecipeItemService recipeItemService;
	
	@Autowired
	private RecipesService recipesService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	 public ResponseEntity<List<RecipeItem>> GetAllRecipesItem()
    {
    	List<RecipeItem> recipes=recipeItemService.getAll();
    	
		return new ResponseEntity<>(recipes,HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<RecipeItem> GetRecipeItemById(@PathVariable int id)
	{
		RecipeItem ritem=recipeItemService.getRecipeItemById(id);
		 
		
		return new ResponseEntity<>(ritem,HttpStatus.OK);
	}

	@PostMapping("/")
	 public ResponseEntity<RecipeItem> saveRecipeItem(@RequestBody RecipeItemDTO recipeItemDTO )
    {
		 RecipeItem ritem=new RecipeItem();
	        ritem.setQuantity(recipeItemDTO.getQuantity());
	        
	        Recipes recipes=recipesService.getRecipesById(recipeItemDTO.getRecipesid());
         ritem.setRecipes(recipes);
         
         Item item =itemService.getItemById(recipeItemDTO.getItemid());
         ritem.setItem(item);
       
	    	RecipeItem saveRecipeItem=recipeItemService.saveRecipeItem(ritem);
	    	return new ResponseEntity<>(saveRecipeItem,HttpStatus.OK);
  
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<RecipeItem> updateRecpieItem(@PathVariable int id, @RequestBody RecipeItemDTO recipeItemDTO)
	{
		
		RecipeItem existingRecipeItem=recipeItemService.getRecipeItemById(id);
		
		if(existingRecipeItem==null)	
		{
			return new ResponseEntity<>(existingRecipeItem,HttpStatus.NOT_FOUND);
		}
		
		existingRecipeItem.setQuantity(recipeItemDTO.getQuantity());
		
		Item item=itemService.getItemById(recipeItemDTO.getItemid());
		existingRecipeItem.setItem(item);
		
		Recipes recipes =recipesService.getRecipesById(recipeItemDTO.getRecipesid());
	    existingRecipeItem.setRecipes(recipes);
	    
		
		RecipeItem updatedRecipeItem=recipeItemService.saveRecipeItem(existingRecipeItem);
					
		return new ResponseEntity<>(updatedRecipeItem,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecipeItem(@PathVariable int id)
	{
		
         recipeItemService.deleteRecipeItemById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
}
