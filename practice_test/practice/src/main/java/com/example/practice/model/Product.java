package com.example.practice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String placeOfProduction;
    private double cost;
    private String unit;
    @OneToMany(mappedBy = "product")
    private List<Consignment> consignmentList;


    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfProduction() {
        return placeOfProduction;
    }

    public void setPlaceOfProduction(String placeOfProduction) {
        this.placeOfProduction = placeOfProduction;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
