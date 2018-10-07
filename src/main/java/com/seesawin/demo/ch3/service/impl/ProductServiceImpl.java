package com.seesawin.demo.ch3.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.seesawin.demo.ch3.model.ProductBeam;
import com.seesawin.demo.ch3.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<ProductBeam> selectProducts() {
		List<ProductBeam> resultList = new ArrayList<ProductBeam>();
		ProductBeam p1 = new ProductBeam();
		p1.setId("1");
		p1.setName("iPhone xs 64g");
		p1.setDscr("銀");
		p1.setPrice("34900");
		
		ProductBeam p2 = new ProductBeam();
		p2.setId("2");
		p2.setName("iPhone xs 64g");
		p2.setDscr("白");
		p2.setPrice("38900");
		
		ProductBeam p3 = new ProductBeam();
		p3.setId("3");
		p3.setName("iWatch 3");
		p3.setDscr("黑");
		p3.setPrice("10000");
		
		ProductBeam p4 = new ProductBeam();
		p4.setId("2");
		p4.setName("Macbook 15");
		p4.setDscr("金");
		p4.setPrice("68900");
		
		resultList.add(p1);
		resultList.add(p2);
		resultList.add(p3);
		resultList.add(p4);
		
		return resultList;
	}

	@Override
	public ProductBeam selectOneProducts(String name) {
		List<ProductBeam> products = selectProducts();
		for(int i = 0; i < products.size(); i++) {
			ProductBeam p = products.get(i);
			if(name != null && name.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<ProductBeam> searchProducts(String name) {
		List<ProductBeam> results = new ArrayList<ProductBeam>();
		List<ProductBeam> products = selectProducts();
		for(int i = 0; i < products.size(); i++) {
			ProductBeam p = products.get(i);
			if(name != null && p.getName().contains(name)) {
				results.add(p);
			}
		}
		return results;
	}

}
