package com.cg.elecpurchapp.service;

import java.util.List;

import com.cg.elecpurchapp.domain.ElecProduct;
/**
 * creating ElecProductService class which provides different services for elecProduct class
 *
 */
public interface ElecProductService {


	ElecProduct findProductByName(String name);

	void removeProduct(ElecProduct elecProduct);

	ElecProduct addProduct(ElecProduct elecProduct);

	public Iterable<ElecProduct> showAllProducts();

	ElecProduct findProductByProductId(int productId);

	ElecProduct updateProduct(int productId, ElecProduct elecProduct);

	Iterable<ElecProduct> findAll();

}

