package com.cg.elecpurchapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.elecpurchapp.domain.Customer;
/**
 * Repository interface implemented for providing various CRUD operations on Customer POJO.
 * @author Cheerala Prathika
 *
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	/**
	 * A method to find the customer inside the repository based on customer identifier.
	 * @param identifier
	 * @return the customer if customer with particular identifier exist.
	 */
	Optional<Customer> findByIdentifier(String identifier);

	//Customer saveOrUpdate(Customer customer);



	


	


}
