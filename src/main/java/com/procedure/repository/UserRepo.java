package com.procedure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.procedure.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
