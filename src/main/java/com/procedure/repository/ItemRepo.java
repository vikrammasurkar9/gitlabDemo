package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
