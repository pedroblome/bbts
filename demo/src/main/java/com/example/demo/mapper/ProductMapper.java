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
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImages(productDto.getImages());
        product.setUser(user);

        return product;
    }

    public ProductDto toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto ProductDto = new ProductDto();
        ProductDto.setName(product.getName());
        ProductDto.setDescription(product.getDescription());
        ProductDto.setPrice(product.getPrice());
        ProductDto.setImages(product.getImages());
        ProductDto.setUserId(product.getUser().getId());

        return ProductDto;
    }
}
