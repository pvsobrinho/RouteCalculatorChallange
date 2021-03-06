package com.avenueCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenueCode.dao.IProductDAO;
import com.avenueCode.entity.Product;
@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductDAO productDAO;
	
	@Override
	public Product getProductById(int productId) {
		Product obj = productDAO.getProductById(productId);
		return obj;
	}	
	
	@Override
	public List<Product> getAllProducts(){
		return productDAO.getAllProducts();
	}	
	
	@Override 
	public List<Product> getAllProductsWithChild(){
		return productDAO.getAllProductsWithChild();
	}
	
	@Override
	public synchronized boolean addProduct(Product product){
       if (productDAO.productExists(product.getDescription(), product.getName())) {
    	   return false;
       } else {
    	   productDAO.addProduct(product);
    	   return true;
       }
	}
	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}
}
