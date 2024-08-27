package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Product;
import com.app.repository.ProductRepository;

@Service
public class SearchService {

	@Autowired
    private ProductRepository productRepository;

    public List<Product> searchProducts(String categoryName, String subCategoryName, String productName) {
         if (categoryName != null) {
            // Search by category
            return productRepository.findByCategoryName(categoryName);
        } else if (productName != null) {
            // Search by product name
            return productRepository.findByProductname(productName);
        } else {
            // If no criteria are provided, return an empty list or all products (depending on your use case)
            return List.of();
        }
    }

	
}
