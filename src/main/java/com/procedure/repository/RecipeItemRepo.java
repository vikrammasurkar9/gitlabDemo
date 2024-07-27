package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.RecipeItem;

@Repository
public interface RecipeItemRepo extends JpaRepository<RecipeItem, Integer> {

}
