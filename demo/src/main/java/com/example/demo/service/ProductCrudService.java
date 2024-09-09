package com.example.demo.service;


import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCrudService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserRepository userRepository;


    public ProductCrudService(ProductRepository productRepository, ProductMapper productMapper,UserRepository userRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userRepository = userRepository;
    }

    public ProductDto createProduct(ProductDto productDto) {
        Optional<User> user = userRepository.findById(productDto.getUserId());

        Product product = productMapper.toEntity(productDto, user);
        productRepository.save(product);

        return productMapper.toDTO(product);

    }

    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            productDtoList.add(productMapper.toDTO(product));
        }
        return productDtoList;
    }

    public List<ProductDto> getAllProductsByUserID(Long userId) {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();
        List<Product> products = productRepository.findByUserId(userId);
        for (Product product : products) {
            productDtoList.add(productMapper.toDTO(product));
        }
        return productDtoList;
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Optional<User> user = userRepository.findById(productDto.getUserId());
        Product product = productMapper.toEntity(productDto, user);
        productRepository.save(product);
        return productMapper.toDTO(product);

    }

    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }
}
