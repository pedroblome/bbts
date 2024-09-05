package com.example.demo.service;


import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public Product createProduct(ProductDto productDto) {
        Optional<User> user = userRepository.findById(productDto.getUserId());

        Product product = productMapper.toEntity(productDto, user);

        return productRepository.save(product);
    }

}
