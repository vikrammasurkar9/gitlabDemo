package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.Recipes;
import com.procedure.repository.RecipesRepo;
import com.procedure.service.RecipesService;

@Service
public class RecipesServiceImpl implements RecipesService {

	@Autowired
	private RecipesRepo recipesRepo;
	
	
	@Override
	public List<Recipes> getAll() {
		List<Recipes> recipes=recipesRepo.findAll();
		return recipes;
	}

	@Override
	public Recipes saveRecipe(Recipes recipes) {
		return recipesRepo.save(recipes);
	}

	@Override
	public Recipes getRecipesById(int id) {
		Recipes recipes=recipesRepo.findById(id).orElse(null);
		return recipes;
	}

	@Override
	public void deleteRecipes(int id) {
		recipesRepo.deleteById(id);

	}

}
