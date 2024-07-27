package com.procedure.controller;

import java.util.ArrayList;
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

import com.procedure.DTO.OrderBazarDTO;
import com.procedure.DTO.OrderRecipeDTO;
import com.procedure.DTO.OrderRecipeItemDTO;
import com.procedure.DTO.OrdersDTO;
import com.procedure.DTO.RecipeBazarDTO;
import com.procedure.entity.Item;
import com.procedure.entity.OrderRecipe;
import com.procedure.entity.OrderRecipeItem;
import com.procedure.entity.Orders;
import com.procedure.entity.RecipeItem;
import com.procedure.entity.Recipes;
import com.procedure.service.ItemService;
import com.procedure.service.OrderRecipeItemService;
import com.procedure.service.OrderRecipeService;
import com.procedure.service.OrdersService;
import com.procedure.service.RecipeItemService;
import com.procedure.service.RecipesService;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private RecipesService recipesService;
	@Autowired
	private RecipeItemService recipeItemService;
	
	@Autowired
	private OrdersService ordersService;
	
	 @Autowired
	 private ItemService itemService;
	 
	 @Autowired
	 private OrderRecipeService orderRecipeService;
	 
	 @Autowired
	 private OrderRecipeItemService orderRecipeItemService;
	
	@GetMapping("/")
	   public ResponseEntity<List<Orders>> GetAllUnits()
    {
    	List<Orders> orders=ordersService.getAll();
    	
		return new ResponseEntity<>(orders,HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Orders> GetOrdersById(@PathVariable int id)
	{
		Orders orders=ordersService.getOrdersById(id);
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}
	
	@GetMapping("/bazarlist/{orderid}")
    public ResponseEntity<List<OrderBazarDTO>>GetBazaarList(@PathVariable ("orderid") int orderid){
		List<OrderBazarDTO> list = ordersService.GetBazarList(orderid);
		return new ResponseEntity<>(list, HttpStatus.OK);
    	
    }
	
	
	@GetMapping("/recipebazar/{id}")
	public ResponseEntity<List<RecipeBazarDTO>> OrderRecipeBazarList(@PathVariable ("id") int id)
	{
		List<RecipeBazarDTO> orderItems = ordersService.generateRecipeBazarList(id);

		return new ResponseEntity<>(orderItems,HttpStatus.OK);
	}

	
	@PostMapping("/")
	public ResponseEntity<Orders> saveOrders(@RequestBody OrdersDTO ordersDTO) {
	    Orders orders = new Orders();

	    // Set orders properties from ordersDTO
	    orders.setName(ordersDTO.getName());
	    orders.setOrderDate(ordersDTO.getOrderDate());
	    orders.setQuantity(ordersDTO.getQuantity());
	    orders.setAddress(ordersDTO.getAddress());
	    orders.setStatus(ordersDTO.getStatus());
	    orders.setEveDate(ordersDTO.getEveDate());
	    orders.setMobileno(ordersDTO.getMobileno());
	    orders.setAmount(ordersDTO.getAmount());
	    orders.setBillamount(ordersDTO.getBillamount());

	    Orders saveOrders = ordersService.saveOrders(orders);

	    // Check if assignedRecipes is not null before iterating
	    if (ordersDTO.getAssignedRecipes() != null) {
	        for (OrderRecipeDTO orderRecipeDto : ordersDTO.getAssignedRecipes()) {
	            Recipes recipes = recipesService.getRecipesById(orderRecipeDto.getRecipeId());
	            OrderRecipe orderRecipe = new OrderRecipe();
	            orderRecipe.setOrders(saveOrders);
	            orderRecipe.setRecipes(recipes);
	            orderRecipe.setAmount(orderRecipeDto.getAmount());
	            orderRecipe.setBillamount(orderRecipeDto.getBillamount());
	            OrderRecipe addedOrderRecipe = orderRecipeService.saveOrderRecipe(orderRecipe);

	            for (OrderRecipeItemDTO dto : orderRecipeDto.getOrderRecipeItemDTOS()) {
	                Item items = itemService.getItemById(dto.getItemId());
	                OrderRecipeItem orderRecipeItem = new OrderRecipeItem();
	                orderRecipeItem.setItem(items);
	                orderRecipeItem.setOrderRecipe(addedOrderRecipe);
	                orderRecipeItem.setRate(dto.getRate());
	                orderRecipeItem.setAmount(dto.getAmount());
	                orderRecipeItem.setQuantity(dto.getQuantity());
	                orderRecipeItemService.saveOrderRecipeItem(orderRecipeItem);
	            
	        }
	    }
	  }

	        return new ResponseEntity<>(saveOrders, HttpStatus.OK);
	}
	

	
//	@PostMapping("/")
//	 public ResponseEntity<Orders> saveOrders(@RequestBody OrdersDTO ordersDTO )
//    {
//        Orders orders=new Orders();
//    	
//        orders.setName(ordersDTO.getName());
//        orders.setOrderDate(ordersDTO.getOrderDate());
//        orders.setQuantity(ordersDTO.getQuantity());
//        orders.setAddress(ordersDTO.getAddress());
//        orders.setStatus(ordersDTO.getStatus());
//        orders.setEveDate(ordersDTO.getEveDate());
//        orders.setMobileno(ordersDTO.getMobileno());
//        orders.setAmount(ordersDTO.getAmount());
//        orders.setBillamount(ordersDTO.getBillamount());
//        
//    	Orders saveOrders=ordersService.saveOrders(orders);
//    	
//    	for (OrderRecipeDTO orderRecipeDto : ordersDTO.getAssignedRecipes()) {
//    		Recipes recipes = recipesService.getRecipesById(orderRecipeDto.getRecipeId());
//			OrderRecipe orderRecipe = new OrderRecipe();
//			orderRecipe.setOrders(saveOrders);
//			orderRecipe.setRecipes(recipes);
//			orderRecipe.setAmount(orderRecipeDto.getAmount());
//			orderRecipe.setBillamount(orderRecipeDto.getBillamount());
//			OrderRecipe addedOrderRecipe = orderRecipeService.saveOrderRecipe(orderRecipe);
//			
//			for(OrderRecipeItemDTO dto : orderRecipeDto.getOrderRecipeItemDTOS()) {
//				Item items = itemService.getItemById(dto.getItemId());
//				OrderRecipeItem orderRecipeItem = new OrderRecipeItem();
//				orderRecipeItem.setItem(items);
//				orderRecipeItem.setOrderRecipe(addedOrderRecipe);
//				orderRecipeItem.setRate(dto.getRate());
//				orderRecipeItem.setAmount(dto.getAmount());
//				orderRecipeItem.setQuantity(dto.getQuantity());
//				orderRecipeItemService.saveOrderRecipeItem(orderRecipeItem);
//			}
//			
//		}
//    	
//    	return new ResponseEntity<>(saveOrders,HttpStatus.OK);
//
//    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Orders> updateOrders(@PathVariable int id, @RequestBody OrdersDTO ordersDTO)
	{
		
		Orders existingOrders=ordersService.getOrdersById(id);
		
		if(existingOrders==null)	
		{
			return new ResponseEntity<>(existingOrders,HttpStatus.NOT_FOUND);
		}
		
		existingOrders.setName(ordersDTO.getName());
		existingOrders.setOrderDate(ordersDTO.getOrderDate());
		existingOrders.setQuantity(ordersDTO.getQuantity());
		existingOrders.setAddress(ordersDTO.getAddress());
		existingOrders.setStatus(ordersDTO.getStatus());
		existingOrders.setEveDate(ordersDTO.getEveDate());
		existingOrders.setMobileno(ordersDTO.getMobileno());
		existingOrders.setAmount(ordersDTO.getAmount());
		existingOrders.setBillamount(ordersDTO.getBillamount());
	
		Orders updatedOrders=ordersService.saveOrders(existingOrders);
		
		return new ResponseEntity<>(updatedOrders,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable int id)
	{
		
        ordersService.deleteOrder(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
			
	}
	
	@GetMapping("/calculaterecipeprice/{recipeId}/{quantity}")
	 public OrderRecipeDTO calculateRecipePrice(@PathVariable int recipeId, @PathVariable int quantity){
		  OrderRecipeDTO orderRecipeDto= new OrderRecipeDTO();
		  Recipes recipe = recipesService.getRecipesById(recipeId);
		  List<RecipeItem> recipeItems=recipeItemService.getAll();
		  
		  List<OrderRecipeItemDTO> orderRecipeItemDtos = new ArrayList<OrderRecipeItemDTO>();
		  
		  double totalAmount = 0;
		  for (RecipeItem recipeItem : recipeItems) {
			if(recipeItem.getRecipes().getRecipeid() == recipeId) {
				Item item=itemService.getItemById(recipeItem.getItem().getItemid());
				double itemRate = item.getRate();
				double amount = itemRate * recipeItem.getQuantity();
				totalAmount += amount;
				
				OrderRecipeItemDTO dto = new OrderRecipeItemDTO();
				dto.setItemId(item.getItemid());
				dto.setOrderRecipeId(0);
				
				double itemQuantity = (double)recipeItem.getQuantity() / (double)recipe.getQuantity();
				
				dto.setQuantity(itemQuantity * quantity);
				dto.setRate(item.getRate());
				dto.setAmount(amount);
				orderRecipeItemDtos.add(dto);
			}
		}
		  double singlePersonAmount = totalAmount / recipe.getQuantity();
		  double totalRecipeAmount = singlePersonAmount * quantity;
		  
		  orderRecipeDto.setOrderId(0);
		  orderRecipeDto.setRecipeId(recipeId);
		  orderRecipeDto.setAmount(totalRecipeAmount);
		  orderRecipeDto.setBillamount(0);
		  orderRecipeDto.setOrderRecipeItemDTOS(orderRecipeItemDtos);
		  
		  return orderRecipeDto;
	  }


}
