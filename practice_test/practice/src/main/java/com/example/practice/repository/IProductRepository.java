package com.example.practice.repository;

import com.example.practice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> getAll();
}
