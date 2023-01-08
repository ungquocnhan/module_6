package com.example.practice.service.impl;

import com.example.practice.model.Consignment;
import com.example.practice.repository.IConsignmentRepository;
import com.example.practice.service.IConsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsignmentService implements IConsignmentService {
    @Autowired
    private IConsignmentRepository consignmentRepository;

    @Override
    public Page<Consignment> getAll(Pageable pageable) {
        return consignmentRepository.getAll(pageable);
    }

    @Override
    public void create(String code, int amount, String importDate, String productionDate, String expirationDate, int productId, boolean flag) {
        consignmentRepository.create(code, amount, importDate, productionDate, expirationDate, productId, flag);
    }

    @Override
    public Optional<Consignment> findId(int id) {
        return consignmentRepository.findId(id);
    }

    @Override
    public void delete(int id) {
        consignmentRepository.delete(id);
    }

    @Override
    public void edit(Consignment consignment) {
        consignmentRepository.edit(consignment.getCode(), consignment.getAmount(), consignment.getImportDate(), consignment.getProductionDate(), consignment.getExpirationDate(), consignment.getProduct().getId(), consignment.getId());
    }

    @Override
    public List<Consignment> search(String code, String importDate, String productName) {
        return consignmentRepository.search(code, importDate, productName);
    }
}
