package com.cg.elecpurchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.elecpurchapp.domain.Payment;
import com.cg.elecpurchapp.service.PaymentService;

@RestController
@RequestMapping("/payments/payment")
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping()
	public ResponseEntity<?> addPayment(@RequestBody Payment payment, BindingResult result) {
		Payment pay = paymentService.save(payment);
		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> removeProduct(@PathVariable("id") int id) {

		paymentService.removePayment(id);

		return new ResponseEntity<String>("Deleted Payment details with Id: " + id + "!", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Payment> showAllPayments(){
		return paymentService.findAll();
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentDetailByPaymentIdentifier(@PathVariable("id") int id) throws Exception {
		Payment payment = paymentService.findPaymentId(id);

		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	@PutMapping(value = "up/{id}")
	public ResponseEntity<?> updatePayment(@RequestBody Payment payment, @PathVariable("id") int id) {
		Payment pay = paymentService.updatePayment(id, payment);
		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}

}
