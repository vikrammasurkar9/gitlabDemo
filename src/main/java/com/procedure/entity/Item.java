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
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemid;
	
	private String name;
	
	private double rate;
	


	@ManyToOne
	@JoinColumn(name = "unitId")
	@JsonIgnoreProperties(value= {"unitId"},allowSetters = true)
	private Unit unit;




	
	
	
}
