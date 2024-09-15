package com.app.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.app.Product;
import com.app.ProductDetails;
import com.app.config.AppConfig;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductDetails productDetails = applicationContext.getBean(ProductDetails.class);
		
		System.out.println("---------- Product List by single parameter ----------");
		String paramName1 = "productId";
		Object paramValue1 = new Integer(3);
		List<Product> productList1 = productDetails.getProductDetailsByParams(paramName1, paramValue1);
		productList1.forEach(p->{System.out.println(p);});
		
		System.out.println("---------- Product List by multiple parameters ---------");
		String[] paramNames1 = {"productId", "productName"};
		Object[] paramValues1 = {4, "Pen"};
		List<Product> productList2 = productDetails.getProductDetailsByParams(paramNames1, paramValues1);
		productList2.forEach(p->{System.out.println(p);});
		
		System.out.println("--------- Product Names List by multiple Parameters --------");
		String[] paramNames2 = {"productId"};
		Object[] paramValues2 = {4};
		List<String> productNameList1 = productDetails.getProductNamesByParams(paramNames2, paramValues2);
		productNameList1.forEach(pn->{System.out.println(pn);});
		
		System.out.println("-------- Product Code And Name List by multiple Parameters -------");
		String[] paramNames3 = {"productName"};
		Object[] paramValues3 = {"Pen"};
		List<Object[]> productCodeAndNameArrayList = productDetails.getProductCodesAndNamesByParams(paramNames3, paramValues3);
		productCodeAndNameArrayList.forEach(pcn->{
			Object[] objectArray = pcn;
			System.out.println(objectArray[0]+" "+objectArray[1]);
		});
	}
}
