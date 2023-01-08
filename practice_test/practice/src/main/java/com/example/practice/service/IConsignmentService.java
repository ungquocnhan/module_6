package com.example.practice.service;

import com.example.practice.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IConsignmentService {
    Page<Consignment> getAll(Pageable pageable);

    void create(String code, int amount, String importDate, String productionDate, String expirationDate, int productId, boolean flag);

    Optional<Consignment> findId(int id);

    void delete(int id);

    void edit(Consignment consignment);

    List<Consignment> search(String code, String importDate, String productName);
}
