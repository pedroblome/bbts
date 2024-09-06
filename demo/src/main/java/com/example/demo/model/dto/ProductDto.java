package com.example.demo.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private Long userId;
}