package com.example.practice.service.impl;

import com.example.practice.model.Product;
import org.springframework.stereotype.Service;
import com.example.practice.repository.IProductRepository;
import com.example.practice.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
