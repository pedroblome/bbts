package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductCrudController {

    private final ProductCrudService productCrudService;


    public ProductCrudController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(ProductDto productDto) {
        return ResponseEntity.ok().body(productCrudService.createProduct(productDto));
    }


}
