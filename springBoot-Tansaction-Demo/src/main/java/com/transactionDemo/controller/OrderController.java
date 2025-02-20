package com.transactionDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactionDemo.DTO.OrderRequest;
import com.transactionDemo.DTO.OrderResponse;
import com.transactionDemo.Service.OrderService;

@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

	
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		//super();
		this.orderService = orderService;
	}
	
	
	@PostMapping
	public ResponseEntity<OrderResponse> placeOrder(OrderRequest orderRequest){
		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
	}
	
	
}
