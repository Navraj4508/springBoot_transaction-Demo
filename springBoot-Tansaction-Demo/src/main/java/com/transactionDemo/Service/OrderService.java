package com.transactionDemo.Service;

import com.transactionDemo.DTO.OrderRequest;
import com.transactionDemo.DTO.OrderResponse;

public interface OrderService {

	OrderResponse placeOrder(OrderRequest orderRequest);
}
