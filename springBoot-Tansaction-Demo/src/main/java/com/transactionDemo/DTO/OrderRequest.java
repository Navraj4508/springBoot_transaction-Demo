package com.transactionDemo.DTO;

import com.transactionDemo.entity.Order;
import com.transactionDemo.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

	private Order order;
	private Payment payment;
}
