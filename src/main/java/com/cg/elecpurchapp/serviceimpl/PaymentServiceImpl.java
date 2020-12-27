package com.cg.elecpurchapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.elecpurchapp.exception.PaymentNotFoundException;
import com.cg.elecpurchapp.domain.Payment;
import com.cg.elecpurchapp.repository.PaymentRepository;
import com.cg.elecpurchapp.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment findPaymentId(int id) {
		Optional<Payment> optionalPayment = paymentRepository.findById(Long.valueOf(id));
		Payment payment;
		if (optionalPayment.isPresent()) {
			payment = optionalPayment.get();
		} else {
			throw new PaymentNotFoundException();
		}
		return payment;

	}

	public Object findByCardHolderName(String string) {
		Optional<Payment> payment = paymentRepository.findByCardHolderName(string);
		if (!payment.isPresent()) {
			throw new PaymentNotFoundException();
		}
		return payment;
	}

	@Override
	
	public Payment saveOrUpdate(Payment payment) {

		return paymentRepository.save(payment);
	}

	@Override
	public void removePayment(int id) {
		Optional<Payment> payment = paymentRepository.findById(Long.valueOf(id));
		paymentRepository.delete(payment.get());

	}
	
	
	@Override
	public Iterable<Payment> showAllPayments(){
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Payment updatePayment(int id, Payment payment) {
		payment.setId(Long.valueOf(id));

		return paymentRepository.save(payment);
	}

	@Override
	public Iterable<Payment> findAll() {
		// TODO Auto-generated method stub
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

}
