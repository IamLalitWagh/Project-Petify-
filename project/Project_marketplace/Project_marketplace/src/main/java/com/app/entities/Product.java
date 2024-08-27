package com.app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private double basePrice;
    
    @Column(nullable = false)
    private double discountPrice;

    @Column(nullable = false)
    private String productname;

    @Column(nullable = false)
    private String description;

    @Lob
	private byte[] Prod_image_1;
	
	@Lob
	private byte[] Prod_image_2;
	
	@Lob
	private byte[] Prod_image_3;
	
	@Lob
	private byte[] Prod_image_4;
	
	@Lob
	private byte[] Prod_image_5;

    
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; 
    
    private double price;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Review> reviews;

	public Product(String name) {
		super();
		this.productname = name;
	}
	
	
}
