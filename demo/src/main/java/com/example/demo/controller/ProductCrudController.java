package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductCrudService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCrudController {

    private final ProductCrudService productCrudService;


    public ProductCrudController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        try {
            return new ResponseEntity<>(productCrudService.getAllProducts(), HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAllProductsByUser(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(productCrudService.getAllProductsByUserID(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }
    @PutMapping()
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto) {
        try{
            return ResponseEntity.ok().body(productCrudService.updateProduct(productDto));

        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("An error occurred updating product: " + e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        try{
            return ResponseEntity.ok().body(productCrudService.createProduct(productDto));

        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("An error occurred creating product: " + e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productCrudService.deleteProduct(id);
            return ResponseEntity.ok().body("Product id: " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("An error occurred creating product: " + e.getMessage());
        }
    }

}
