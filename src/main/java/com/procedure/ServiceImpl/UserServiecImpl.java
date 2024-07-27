package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.User;
import com.procedure.repository.UserRepo;
import com.procedure.service.UserService;

@Service
public class UserServiecImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<User> getAll() {
		
		List<User> user = userRepo.findAll();
		
		return user;
	}

	@Override
	public User getUserById(int id) {
		 User user=userRepo.findById(id).orElse(null);
			return user;
	}

	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(int id) {
		
		userRepo.deleteById(id);
		
	}

}
