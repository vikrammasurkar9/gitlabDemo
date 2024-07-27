package com.procedure.DTO;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class OrdersDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Date orderDate;
	private String name;
	private Date eveDate;
	private long mobileno;
	private String address;
	private long quantity;
	private String status;
	private long amount;
	private long billamount;
	
	private List<OrderRecipeDTO> assignedRecipes;
}
