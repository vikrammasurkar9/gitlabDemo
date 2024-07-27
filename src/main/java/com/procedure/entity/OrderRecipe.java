package com.procedure.entity;

import java.sql.Date;

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
@Table (name = "orderrecipes")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OrderRecipe {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private int orderrecipeid;
	private double amount;
	private double billamount;
	
	@ManyToOne
	@JoinColumn(name = "OrderId")
	@JsonIgnoreProperties(value= {"OrderId"},allowSetters = true)
	private Orders orders;

	@ManyToOne
	@JoinColumn(name="RecipeId")
	@JsonIgnoreProperties(value= {"RecipeId"},allowSetters = true)
	private Recipes recipes;
	
}
