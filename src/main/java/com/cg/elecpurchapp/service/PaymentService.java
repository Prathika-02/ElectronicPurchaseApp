package com.cg.elecpurchapp.service;

import com.cg.elecpurchapp.domain.Payment;

import java.util.List;

public interface PaymentService {

	Payment findPaymentId(int id);

	Payment addPayment(Payment payment);

	void removePayment(int id);

	Payment updatePayment(int id, Payment payment);

	public Iterable<Payment> showAllPayments();

	Iterable<Payment> findAll();

	Payment saveOrUpdate(Payment payment);

	Payment save(Payment payment);

    

}