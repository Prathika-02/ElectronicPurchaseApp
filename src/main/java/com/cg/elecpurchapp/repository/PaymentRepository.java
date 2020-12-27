package com.cg.elecpurchapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.elecpurchapp.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	public Optional<Payment> findByCardHolderName(String name);

	public Optional<Payment> findPaymentByCardHolderName(String string);

}
