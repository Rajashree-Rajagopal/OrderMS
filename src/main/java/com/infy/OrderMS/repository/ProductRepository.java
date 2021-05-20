package com.infy.OrderMS.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.infy.OrderMS.entity.ProductsOrdered;

public interface ProductRepository extends JpaRepository<ProductsOrdered, Integer>{
	public List<ProductsOrdered> findById(int orderId);


}
