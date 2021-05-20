package com.infy.OrderMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.OrderMS.DTO.OrderDTO;
import com.infy.OrderMS.DTO.ProductsOrderedDTO;
import com.infy.OrderMS.service.OrderService;
import com.infy.OrderMS.service.ProductsOrderedService;


@RestController
@CrossOrigin
public class OrderController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderService orderService;
	@Autowired
	ProductsOrderedService prodService;
	@GetMapping(value = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO getorderDetails(@PathVariable int orderId){

		logger.info("Orders placed by the users {}", orderId);

		return orderService.getOrderDetails(orderId);
	}
	@PostMapping(value = "/order/placeOrder", consumes = MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<String> placeorders(@RequestBody OrderDTO orderDTO) { 
		 logger.info("Orders placed successfully", orderDTO);
		 return new ResponseEntity<>( orderService.placeOrders(orderDTO),HttpStatus.CREATED); 
		 }
	
			/*
			 * @RequestMapping(value="/productsordered/{prodId}",method=RequestMethod.GET)
			 * public ResponseEntity<ProductsOrderedDTO> getProductsById(@PathVariable int
			 * orderId) {
			 * 
			 * ProductsOrderedDTO productFromDB = OrderService.getProductsById(orderId);
			 * 
			 * return new ResponseEntity<ProductsOrderedDTO>(productFromDB,HttpStatus.OK);
			 * 
			 * }
			 */
	@GetMapping(value = "/productsordered/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductsOrderedDTO> getProductsOrdered(@PathVariable int orderId){

		logger.info("Orders placed by the users {}", orderId);

		return prodService.getProductsOrdered(orderId);
	}
	@PostMapping(value = "/product/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addNewProduct( @RequestBody ProductsOrderedDTO spDTO) {
		
		return new ResponseEntity<>( prodService.addNewProduct(spDTO),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/product",  produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ProductsOrderedDTO> getSubscribedProductId() {
		
			return prodService.getProductId();
	}
	

}
