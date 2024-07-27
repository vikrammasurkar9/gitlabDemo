package com.procedure.service;

import java.util.List;

import com.procedure.entity.Unit;

public interface UnitService {
	
	public List <Unit> getAll();
	
	public Unit getUnitById(int id);
	
	public Unit saveUnit(Unit unit);
	
	public void deleteUnit(int id);

}
