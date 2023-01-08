package com.example.practice.dto;

import com.example.practice.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ConsignmentDto implements Validator {
    private int id;
    @Pattern(regexp = "^LH[-][0-9]{4}$")
    private String code;
    @Min(value = 0)
    private int amount;
    @NotBlank
    private String importDate;
    @NotBlank
    private String productionDate;
    @NotBlank
    private String expirationDate;
    private Product product;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ConsignmentDto consignmentDto = (ConsignmentDto) target;

        if (consignmentDto.getCode() == null){
            errors.rejectValue("code", "code.null", "Không được để trống");
        }else if (consignmentDto.getCode().length() > 10){
            errors.rejectValue("code", "code.length", "Không được quá 10 kí tự");
        }

        if (consignmentDto.getCode().length() > 10){
            errors.rejectValue("code", "code.length", "Không được quá 10 kí tự");
        }
    }

    public ConsignmentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
