package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto productDto, Optional<User> userOptional) {
        if (productDto == null) {
            return null;
        }

        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("User not found"));

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setUrlImage(productDto.getUrlImage());
        product.setUser(user);

        return product;
    }

    public ProductDto toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setUrlImage(product.getUrlImage());
        productDto.setUserId(product.getUser().getId());

        return productDto;
    }
}
