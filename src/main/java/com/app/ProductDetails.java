package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetails {
	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> getProductDetailsByParams(String paramName, Object paramValue){
		List<Product> productList = productDAO.getProductByParams(paramName, paramValue);
		
		return productList;
	}
	
	public List<Product> getProductDetailsByParams(String[] paramNames, Object[] paramValues){
		List<Product> productList = productDAO.getProductByParams(paramNames, paramValues);
		
		return productList;
	}
	
	public List<String> getProductNamesByParams(String[] paramNames, Object[] paramValues){
		List<String> productNameList = productDAO.getProductNameByParams(paramNames, paramValues);
	
		return productNameList;
	}
	
	public List<Object[]> getProductCodesAndNamesByParams(String[] paramNames, Object[] paramValues){
		List<Object[]> productNameAndCodeArrayList = productDAO.getProductCodeAndNameByParams(paramNames, paramValues);
		
		return productNameAndCodeArrayList;
	}
}
