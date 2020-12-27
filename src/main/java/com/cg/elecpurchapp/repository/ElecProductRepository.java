package com.cg.elecpurchapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.elecpurchapp.domain.ElecProduct;

/**
 * creating ElecProductRespository Interface which extends JpaRespository which provides CRUD operations
 *
 */

@Repository
public interface ElecProductRepository extends CrudRepository<ElecProduct, Integer>{

	public Optional<ElecProduct> findProductByProductId(int productId);

	public Optional<ElecProduct> findByName(String name);

}
