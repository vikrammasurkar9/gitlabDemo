package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.OrderRecipeItem;

@Repository
public interface OrderRecipeItemRepo extends JpaRepository<OrderRecipeItem, Integer> {

}
