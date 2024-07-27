package com.procedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procedure.DTO.UserDTO;
import com.procedure.entity.User;
import com.procedure.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> GetAllEmployee()
	{
		
		List<User> employee=userService.getAll();
		
		
		return new ResponseEntity<>(employee,HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> GetUserById(@PathVariable int id)
	{
		User user = userService.getUserById(id);
		 
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<User> saveEmployee(@RequestBody UserDTO userDTO)
	{
		
		User user = new User();
		
		user.setName(userDTO.getName());
		user.setMobileno(userDTO.getMobileno());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		
		User saveUser = userService.saveUser(user);
		
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updatedUser(@PathVariable int id, @RequestBody UserDTO userDTO )
	{
		User existingUser = userService.getUserById(id);
		
		if(existingUser == null)
		{
			return new ResponseEntity<>(existingUser,HttpStatus.NOT_FOUND);
		}
		
		existingUser.setName(userDTO.getName());
		existingUser.setMobileno(userDTO.getMobileno());
		existingUser.setEmail(userDTO.getEmail());
		existingUser.setPassword(userDTO.getPassword());
		
		User updatedUser = userService.saveUser(existingUser);
		
		return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteUser(@PathVariable int id)
	
	{
		userService.deleteUser(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
