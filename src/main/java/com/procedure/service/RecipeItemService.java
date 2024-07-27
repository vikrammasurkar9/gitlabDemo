package com.procedure.service;

import java.util.List;

import com.procedure.entity.RecipeItem;

public interface RecipeItemService {
	
	public List<RecipeItem> getAll();

	public RecipeItem saveRecipeItem(RecipeItem recipeItem);

	public RecipeItem getRecipeItemById(int id);
	
	public void deleteRecipeItemById(int id);

}
