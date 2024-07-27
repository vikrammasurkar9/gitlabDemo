package com.procedure.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procedure.entity.Unit;
import com.procedure.entity.User;
import com.procedure.repository.UnitRepo;
import com.procedure.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepo unitRepo;
	
	@Override
	public List<Unit> getAll() {
		
		List<Unit> unit = unitRepo.findAll();
		
		return unit;
	}
	
	@Override
	public Unit getUnitById(int id) {
		
		return unitRepo.findById(id).orElse(null);
	}

	@Override
	public Unit saveUnit(Unit unit) {
		
		return unitRepo.save(unit) ;
	}

	@Override
	public void deleteUnit(int id) {
		
		unitRepo.deleteById(id);
	}

}
