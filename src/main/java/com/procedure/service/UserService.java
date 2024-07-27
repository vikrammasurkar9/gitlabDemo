package com.procedure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.procedure.entity.User;

public interface UserService {
	
	public List<User> getAll();
	
	public User getUserById(int id);
	
	public User saveUser (User user);
	
	public void deleteUser(int id);

}
