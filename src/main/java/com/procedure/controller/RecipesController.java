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

import com.procedure.DTO.RecipesDTO;
import com.procedure.entity.Recipes;
import com.procedure.service.RecipesService;

@CrossOrigin
@RestController
@RequestMapping("/recipes")
public class RecipesController {
	
	@Autowired
	private RecipesService recipesService;
	
	@GetMapping("/")
	 public ResponseEntity<List<Recipes>> GetAllRecipes()
	    {
	    	List<Recipes> recipes=recipesService.getAll();
	    	
			return new ResponseEntity<>(recipes,HttpStatus.OK);
	    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipes> GetRecipesById(@PathVariable int id)
	{
		Recipes recipes=recipesService.getRecipesById(id);
		 
		
		return new ResponseEntity<>(recipes,HttpStatus.OK);
	}
	
	@PostMapping("/")
	  public ResponseEntity<Recipes> saveRecipes(@RequestBody RecipesDTO recipesDTO )
    {
        Recipes recipes=new Recipes();
    	
        recipes.setName(recipesDTO.getName());
        recipes.setQuantity(recipesDTO.getQuantity());
        recipes.setDescription(recipesDTO.getDescription());
    	
    	Recipes saveRecipes=recipesService.saveRecipe(recipes);
    	
    	return new ResponseEntity<>(saveRecipes,HttpStatus.OK);
    	
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Recipes> updateRecpies(@PathVariable int id, @RequestBody RecipesDTO recipesDTO)
	{
		
		Recipes existingRecipes=recipesService.getRecipesById(id);
		
		if(existingRecipes==null)	
		{
			return new ResponseEntity<>(existingRecipes,HttpStatus.NOT_FOUND);
		}
		
		existingRecipes.setName(recipesDTO.getName());
		existingRecipes.setQuantity(recipesDTO.getQuantity());
		existingRecipes.setDescription(recipesDTO.getDescription());
		
		Recipes updatedrecRecipes=recipesService.saveRecipe(existingRecipes);
		
		return new ResponseEntity<>(updatedrecRecipes,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecipes(@PathVariable int id)
	{
		
		recipesService.deleteRecipes(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
			
	}

}
