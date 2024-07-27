package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.Recipes;

@Repository
public interface RecipesRepo extends JpaRepository<Recipes, Integer> {

}
