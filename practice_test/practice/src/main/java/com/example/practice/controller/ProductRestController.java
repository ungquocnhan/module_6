package com.example.practice.controller;

import com.example.practice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.practice.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin("*")
public class ProductRestController {
    private final IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> productList = productService.getAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
