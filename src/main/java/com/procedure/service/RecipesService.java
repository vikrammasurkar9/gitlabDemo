package com.procedure.service;

import java.util.List;

import com.procedure.entity.Recipes;

public interface RecipesService {

	public List<Recipes> getAll();
	
	public Recipes saveRecipe(Recipes recipes);

	public Recipes getRecipesById(int id);
	
	public void deleteRecipes(int id);
	
}
