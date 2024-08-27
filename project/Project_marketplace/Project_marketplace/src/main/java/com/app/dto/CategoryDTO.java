package com.app.dto;

import lombok.*;
import java.util.Set;

import com.app.entities.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private Set<SubCategoryDTO> subCategories;
    private Set<Product> products;
}
