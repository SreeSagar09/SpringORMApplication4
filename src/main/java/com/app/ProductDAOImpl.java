package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Product> getProductByParams(String paramName, Object paramValue) {
		String queryString = "from Product p where p.productId= :productId";
		List<Product> productList = (List<Product>) hibernateTemplate.findByNamedParam(queryString, paramName, paramValue);
		
		return productList;
	}

	@Override
	public List<Product> getProductByParams(String[] paramNames, Object[] paramValues) {
		String queryString = "from Product p where p.productId= :productId and p.productName= :productName";
		List<Product> productList = (List<Product>) hibernateTemplate.findByNamedParam(queryString, paramNames, paramValues);
		
		return productList;
	}

	@Override
	public List<String> getProductNameByParams(String[] paramNames, Object[] paramValues) {
		String queryString = "select p.productName from Product p where p.productId= :productId";
		List<String> productNameList = (List<String>) hibernateTemplate.findByNamedParam(queryString, paramNames, paramValues);
		
		return productNameList;
	}

	@Override
	public List<Object[]> getProductCodeAndNameByParams(String[] paramNames, Object[] paramValues) {
		String queryString = "select p.productCode, p.productName from Product p where p.productName= :productName";
		List<Object[]> productNameAndCodeArrayList = (List<Object[]>) hibernateTemplate.findByNamedParam(queryString, paramNames, paramValues);
		
		return productNameAndCodeArrayList;
	}

}
