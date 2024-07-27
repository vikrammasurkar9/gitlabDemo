package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.OrderRecipe;

@Repository
public interface OrderRecipeRepo extends JpaRepository<OrderRecipe, Integer> {

}
