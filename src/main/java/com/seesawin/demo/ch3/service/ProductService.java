package com.seesawin.demo.ch3.service;

import java.util.List;

import com.seesawin.demo.ch3.model.ProductBeam;

public interface ProductService {
	List<ProductBeam> selectProducts();
	
	List<ProductBeam> searchProducts(String name);

	ProductBeam selectOneProducts(String name);
}
