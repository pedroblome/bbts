package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductCrudService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductCrudController {

    private final ProductCrudService productCrudService;


    public ProductCrudController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        System.out.println("create Product");

        return ResponseEntity.ok().body(productCrudService.createProduct(productDto));
    }

    @GetMapping("/test")
    public ResponseEntity<?>  retornoTeste() {
        System.out.println("testando imprimir do retornoTeste");
        return ResponseEntity.ok("saida ok");
    }


}
