package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.Unit;

@Repository
public interface UnitRepo extends JpaRepository<Unit, Integer> {

}

