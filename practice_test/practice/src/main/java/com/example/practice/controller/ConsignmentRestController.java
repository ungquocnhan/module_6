package com.example.practice.controller;

import com.example.practice.dto.ConsignmentDto;
import com.example.practice.model.Consignment;
import com.example.practice.service.IConsignmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consignments")
@CrossOrigin(origins = "*")
public class ConsignmentRestController {
    @Autowired
    private IConsignmentService consignmentService;

    @GetMapping("")
    public ResponseEntity<Page<Consignment>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Consignment> consignmentList = consignmentService.getAll(pageable);
        return new ResponseEntity<>(consignmentList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody ConsignmentDto consignmentDto, BindingResult bindingResult) {
        new ConsignmentDto().validate(consignmentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        Consignment consignment = new Consignment();
        BeanUtils.copyProperties(consignmentDto, consignment);
        consignment.setFlag(true);
        consignmentService.create(consignment.getCode(), consignment.getAmount(), consignment.getImportDate(), consignment.getProductionDate(), consignment.getExpirationDate(), consignment.getProduct().getId(), consignment.isFlag());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Consignment> detete(@PathVariable("id") int id) {
        Optional<Consignment> consignment = consignmentService.findId(id);
        if (!consignment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        consignmentService.delete(consignment.get().getId());
        return new ResponseEntity<>(consignment.get(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Consignment> findId(@PathVariable("id") int id) {
        Optional<Consignment> consignment = consignmentService.findId(id);
        if (!consignment.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consignment.get(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody ConsignmentDto consignmentDto, BindingResult bindingResult, @PathVariable("id") int id) {
        new ConsignmentDto().validate(consignmentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        Consignment consignment = consignmentService.findId(id).get();
        consignment.setId(id);
        consignment.setCode(consignmentDto.getCode());
        consignment.setAmount(consignmentDto.getAmount());
        consignment.setImportDate(consignmentDto.getImportDate());
        consignment.setProductionDate(consignmentDto.getProductionDate());
        consignment.setExpirationDate(consignmentDto.getExpirationDate());
        consignment.setProduct(consignmentDto.getProduct());
        consignmentService.edit(consignment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<Consignment>> search(@RequestParam String code,
                                                    @RequestParam String importDate,
                                                    @RequestParam String productName) {
        List<Consignment> consignmentPage = consignmentService.search(code, importDate, productName);
        if (consignmentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(consignmentPage, HttpStatus.OK);
    }
}
