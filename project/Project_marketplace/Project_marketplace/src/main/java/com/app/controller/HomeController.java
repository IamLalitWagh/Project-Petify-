package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.CategoryService;
import com.app.service.ProductService;


@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CategoryService CategoryService;

    @Autowired
    private ProductService productService;
    
  // Endpoint to fetch products by category name
        @GetMapping("/{categoryName}/products")
        public List<Product> getProductsByCategoryName(@PathVariable String categoryName) {
            return productService.getProductsByCategoryName(categoryName);
        }
              

        
//  @PostMapping
//  public ResponseEntity<Category> createcategory(@RequestBody Category category) {
//  	Category savedCategory = CategoryService.save(category);
//      return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
//  }
//      
    
    @GetMapping("/products")
    public List<Product> getcategoryByName(@PathVariable String name) {
        
        return productService.findAll();
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSubcategoryById(@PathVariable Long id) {
//        CategoryService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
