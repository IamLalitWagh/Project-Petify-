package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Query products by name containing a string (case-insensitive)
    List<Product> findByProductnameContainingIgnoreCase(String name);
    
    // Find a product by its ID
    Optional<Product> findById(Long id);

    
	List<Product> findByProductnameContaining(String name);

    
    // Find products by category
    List<Product> findByCategoryName(String categoryName);


    // Find products by product name
    List<Product> findByProductname(String productName);
    
    //for filtering the products based on category,subcategory and price
    @Query("SELECT p FROM Product p WHERE (:categoryName IS NULL OR p.category.name = :categoryName) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice)")
    List<Product> findProductsByCategoryAndPrice(
            @Param("categoryName") String categoryName,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice
    );
}
