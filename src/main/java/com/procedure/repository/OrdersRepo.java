package com.procedure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.procedure.DTO.OrderBazarDTO;
import com.procedure.DTO.RecipeBazarDTO;
import com.procedure.entity.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

	@Query(value = "SELECT I.name, U.name AS unitname, ORI.rate, SUM(ORI.quantity) AS quantity " +
	        "FROM orderrecipes AS O_R INNER JOIN orderrecipeitems AS ORI ON O_R.orderrecipeid = ORI.order_recipe_id " +
			"INNER JOIN items AS I ON I.itemid = ORI.item_id " +
	        "INNER JOIN units AS U ON U.id = I.unit_id " +
			"WHERE O_R.order_id = :orderId GROUP BY I.name, U.name, ORI.rate", nativeQuery = true)
	List<OrderBazarDTO>getalldata(@Param("orderId")int orderId);
	
	@Query(value = "SELECT * FROM recipes as R " +
	               "JOIN orderrecipes as O ON r.recipeid = O.recipe_id " +
			        "WHERE O.order_id = :orderId " +
	                "GROUP BY R.name, O.billamount " +
			        "ORDER BY R.name", nativeQuery = true)
	List<RecipeBazarDTO> generateRecipeBazarList(@Param("orderId")int orderId);

}

  