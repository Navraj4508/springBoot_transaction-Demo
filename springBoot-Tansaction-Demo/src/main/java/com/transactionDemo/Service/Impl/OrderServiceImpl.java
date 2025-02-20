package com.transactionDemo.Service.Impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transactionDemo.DTO.OrderRequest;
import com.transactionDemo.DTO.OrderResponse;
import com.transactionDemo.Service.OrderService;
import com.transactionDemo.entity.Order;
import com.transactionDemo.entity.Payment;
import com.transactionDemo.exception.PaymentException;
import com.transactionDemo.repository.OrderRepository;
import com.transactionDemo.repository.PaymentRepository;

@Service
public class OrderServiceImpl implements OrderService {

	
	private OrderRepository orderRepository;
	private PaymentRepository paymentRepository;
	
	
	public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
	}


	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		
		Order order = orderRequest.getOrder();
		order.setStatus("IN PROGRESS");
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		orderRepository.save(order);
		
		Payment payment = orderRequest.getPayment();
		
		if(!payment.getType().equals("DEBIT")) {
			throw new PaymentException("Payment card type do not support!");
		}
		
		payment.setOrderId(order.getId());
		paymentRepository.save(payment);
		
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setMessage("SUCCESS");
		
		return orderResponse;
	}

}
