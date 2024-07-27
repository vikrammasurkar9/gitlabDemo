package com.procedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procedure.DTO.UnitDTO;
import com.procedure.DTO.UserDTO;
import com.procedure.entity.Unit;
import com.procedure.entity.User;
import com.procedure.service.UnitService;

@CrossOrigin
@RestController
@RequestMapping("/unit")
public class UnitController {
 
	@Autowired
	private UnitService unitService;
	
	@GetMapping("/")
	public ResponseEntity<List<Unit>> GetAllUnit()
	{
		List<Unit> unit=unitService.getAll();
		
		return new ResponseEntity<>(unit,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Unit> GetUnitById(@PathVariable int id)
	{
		Unit unit = unitService.getUnitById(id);
		 
		return new ResponseEntity<>(unit,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Unit> saveEmployee(@RequestBody UnitDTO unitDTO)
	{
		Unit unit = new Unit();
		
		unit.setName(unitDTO.getName());
		
		Unit saveUnit = unitService.saveUnit(unit);
		
		return new ResponseEntity<>(saveUnit,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Unit> updatedUser(@PathVariable int id, @RequestBody UnitDTO unitDTO )
	{
		Unit existingUnit = unitService.getUnitById(id);
		
		if(existingUnit == null)
		{
			return new ResponseEntity<>(existingUnit,HttpStatus.NOT_FOUND);
		}
		
		existingUnit.setName(unitDTO.getName());
		
		Unit updatedUnit = unitService.saveUnit(existingUnit);
		
		return new ResponseEntity<>(updatedUnit,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteUnit(@PathVariable int id)
		
		{
			unitService.deleteUnit(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
}
