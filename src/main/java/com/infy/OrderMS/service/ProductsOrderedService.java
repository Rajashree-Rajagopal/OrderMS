package com.infy.OrderMS.service;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.OrderMS.DTO.ProductsOrderedDTO;
import com.infy.OrderMS.entity.ProductsOrdered;
import com.infy.OrderMS.repository.ProductRepository;


@Service
public class ProductsOrderedService {
	@Autowired
	private ProductRepository prodRepo;

	public List<ProductsOrderedDTO> getProductsOrdered(int orderId) {
		Iterable<ProductsOrdered> productsordered = prodRepo.findById(orderId);
		
		List<ProductsOrderedDTO> productsorderedDTO = new ArrayList<>();//ProductsOrderedDTO.valueOf(productsordered);
		

		productsordered.forEach(po ->{
			ProductsOrderedDTO p = new ProductsOrderedDTO();
			p.setOrderId(po.getOrderId());
			p.setProdId(po.getProdId());
			p.setSellerId(po.getSellerId());
			p.setQuantity(po.getQuantity());
			productsorderedDTO.add(p);
			
		});
		return productsorderedDTO;
	}
	
public String addNewProduct(ProductsOrderedDTO sptDto) {
		
		ProductsOrdered spd= new ProductsOrdered();
		spd.setOrderId(sptDto.getOrderId());
		spd.setProdId(sptDto.getProdId());
		spd.setSellerId(sptDto.getSellerId());
		spd.setQuantity(sptDto.getQuantity());
		prodRepo.save(spd);
		return "saved";
	}


	

	public List<ProductsOrderedDTO> getProductId() {
		// TODO Auto-generated method stub
Iterable<ProductsOrdered> productsordered = prodRepo.findAll();
		
		List<ProductsOrderedDTO> productsorderedDTO = new ArrayList<>();
		productsordered.forEach(po ->{
			ProductsOrderedDTO p = new ProductsOrderedDTO();
			p.setOrderId(po.getOrderId());
			p.setProdId(po.getProdId());
			p.setSellerId(po.getSellerId());
			p.setQuantity(po.getQuantity());
			productsorderedDTO.add(p);
			
		});
		return productsorderedDTO;
	}
	

	

}
