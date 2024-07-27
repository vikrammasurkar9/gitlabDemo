package com.procedure.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name = "orderrecipeitems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderRecipeItem {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double quantity;
	private double rate;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "OrderRecipeId")
	@JsonIgnoreProperties(value= {"OrderRecipeId"},allowSetters = true)
	private OrderRecipe orderRecipe;

	
	@ManyToOne
	@JoinColumn(name="ItemId")
	@JsonIgnoreProperties(value= {"ItemId"},allowSetters = true)
	private Item item;
	
	
	
}
