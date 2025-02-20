package com.transactionDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionDemo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
