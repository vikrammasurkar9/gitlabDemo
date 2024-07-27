package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.RecipeItem;
import com.procedure.repository.RecipeItemRepo;

import com.procedure.service.RecipeItemService;

@Service
public class RecipeItemServiceImpl implements RecipeItemService {
	
	@Autowired
	private RecipeItemRepo recipeItemRepo;

	@Override
	public List<RecipeItem> getAll() {
		List<RecipeItem> recipeitem=recipeItemRepo.findAll();
		return recipeitem;
	}

	@Override
	public RecipeItem saveRecipeItem(RecipeItem recipeItem) {
		
		return recipeItemRepo.save(recipeItem);
	}

	@Override
	public RecipeItem getRecipeItemById(int id) {
		RecipeItem recipeItem=recipeItemRepo.findById(id).orElse(null);
		return recipeItem;
	}

	@Override
	public void deleteRecipeItemById(int id) {
		recipeItemRepo.deleteById(id);

	}


}
