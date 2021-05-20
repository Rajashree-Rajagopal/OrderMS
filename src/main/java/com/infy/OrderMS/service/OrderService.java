package com.infy.OrderMS.service;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.OrderMS.DTO.OrderDTO;
import com.infy.OrderMS.DTO.ProductsOrderedDTO;
import com.infy.OrderMS.entity.Order;
import com.infy.OrderMS.entity.ProductsOrdered;
import com.infy.OrderMS.repository.OrderRepository;
import com.infy.OrderMS.repository.ProductRepository;

@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepo;
	
	public OrderDTO getOrderDetails(int orderId) {
		Order order = orderRepo.findByOrderId(orderId);
		
		OrderDTO orderDTO = OrderDTO.valueOf(order);
		
		logger.info("Orders placed by the user {}", orderId);

		if (orderDTO == null) {
			logger.info("Empty list no products found in db");
		}
return orderDTO;
	}

	public String placeOrders(OrderDTO orderDTO) {

		Order order=OrderDTO.createOrder(orderDTO);
		orderRepo.save(order);
		return "order placed successfully";
		}
	
	
}
