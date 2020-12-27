package com.cg.elecpurchapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.elecpurchapp.exception.ProductNotFoundException;
import com.cg.elecpurchapp.domain.ElecProduct;
import com.cg.elecpurchapp.service.ElecProductService;

/**
 * creating a class ElecProductController which controls all the services related to ElecProduct
 *
 */
    @CrossOrigin(origins = "http://localhost:3000")
	@RestController
	@RequestMapping("/api/product")
	public class ElecProductController {
		
		/**
		 * creating an instance for ElecProductService and autowiring is used to instantiate the object
		 */
		@Autowired
		private ElecProductService elecProductService;
		
		@PostMapping("")
		public ResponseEntity<?> addProduct( @RequestBody ElecProduct elecProduct, BindingResult result) {
			ElecProduct newelecProduct = elecProductService.addProduct(elecProduct);
			return new ResponseEntity<ElecProduct>(newelecProduct,HttpStatus.OK);
		}
		@GetMapping("/all")
		public Iterable<ElecProduct> showAllProducts(){
			return elecProductService.findAll();
		}
		
		@DeleteMapping("/delete/{productId}")
		public ResponseEntity<?> removeProduct(@PathVariable("productId") ElecProduct productId) {
			 elecProductService.removeProduct(productId);
			return new ResponseEntity<String>("Deleted Product details with Id: "+productId+"!",HttpStatus.OK);
		}
	
		@PutMapping(value="/{productId}")
		public ResponseEntity<?> updateProduct(@RequestBody ElecProduct elecProduct, @PathVariable("productId") int productId) {
			ElecProduct updatedProduct = elecProductService.updateProduct(productId, elecProduct);
			return new ResponseEntity<ElecProduct>(updatedProduct, HttpStatus.OK);
		}
		
		@GetMapping("/{productId}")
		public ResponseEntity<ElecProduct> getProductDetailByProductId(@PathVariable("productId") int productId) throws Exception {
			ElecProduct elecProduct = elecProductService.findProductByProductId(productId);
           return new ResponseEntity<>(elecProduct, HttpStatus.OK);
		}
	}