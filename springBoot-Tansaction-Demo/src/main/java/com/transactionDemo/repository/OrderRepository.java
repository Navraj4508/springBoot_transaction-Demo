package com.transactionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionDemo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
