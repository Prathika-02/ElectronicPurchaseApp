package com.cg.elecpurchapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.elecpurchapp.exception.ProductNotFoundException;
import com.cg.elecpurchapp.domain.ElecProduct;
import com.cg.elecpurchapp.repository.ElecProductRepository;
import com.cg.elecpurchapp.service.ElecProductService;

@Service
public class ElecProductServiceImpl implements ElecProductService {
	

	@Autowired
	private ElecProductRepository elecProductRepository;

	/**
	 * findProductByProductId method to find the  details of product in elecproduct table in database*/
	@Override
	public ElecProduct findProductByProductId(int productId) {

		ElecProduct elecProduct = null;
		Optional<ElecProduct> optionalElecProduct = elecProductRepository.findProductByProductId(productId);
		if(optionalElecProduct.isPresent()) {
			elecProduct = optionalElecProduct.get();
		}else {
			throw new ProductNotFoundException();
		}
		return elecProduct;
	}
	/**
	 * findProductByProductName method to find the  details of product in elecproduct table in database*/
	@Override
	public ElecProduct findProductByName(String name) {
		ElecProduct elecProduct = null;
		Optional<ElecProduct> optionalElecProduct=  elecProductRepository.findByName(name);
		if(optionalElecProduct.isPresent()) {
			elecProduct = optionalElecProduct.get();
		} else {
			throw new ProductNotFoundException();
		}
		return elecProduct;
	}
	
	/**
	 * removeProduct method to remove the  details of product in elecproduct table in database*/
	public void removeProduct(ElecProduct elecProduct) {
		elecProductRepository.delete(elecProduct);
		
	}
	
	/**
	 *addProduct method to add the details of products in elecproduct table in database*/
    public ElecProduct addProduct(ElecProduct elecProduct) {
		return elecProductRepository.save(elecProduct);
	}
    
    /**
	 * showAllProducts method to display all the products in elecproduct table in database*/
	@Override
	public Iterable<ElecProduct> showAllProducts(){
		List<ElecProduct> productList = (List<ElecProduct>) elecProductRepository.findAll();
		return productList;
	}
	
    
	/**
	 * updateProduct method to update the  details of product in elecproduct table in database*/
	@Override
	public ElecProduct updateProduct(int productId, ElecProduct elecProduct) {
		elecProduct.setProductId(Integer.valueOf(productId));

		return elecProductRepository.save(elecProduct);
	}
	@Override
	public Iterable<ElecProduct> findAll() {
		List<ElecProduct> productList = (List<ElecProduct>) elecProductRepository.findAll();
		return productList;
	}
	
}