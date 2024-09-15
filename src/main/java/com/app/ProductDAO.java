package com.app;

import java.util.List;

public interface ProductDAO {
	
	public List<Product> getProductByParams(String paramName, Object paramValue);
	
	public List<Product> getProductByParams(String[] paramNames, Object[] paramValues);
	
	public List<String> getProductNameByParams(String[] paramNames, Object[] paramValues);
	
	public List<Object[]> getProductCodeAndNameByParams(String[] paramNames, Object[] paramValues);
}
