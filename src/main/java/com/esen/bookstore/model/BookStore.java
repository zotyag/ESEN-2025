package com.esen.bookstore.model;


import jakarta.persistence.*;
//import lombok.Data;
import java.util.Map;

//@Data
@Entity
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String location;
    private Double priceModifyer;
    private Double moneyInCashRegister;


    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Book, Integer> inventory;

    public BookStore(long id, String location, Double priceModifier, Double moneyInCashRegister, Map<Book, Integer> inventory) {
        this.id = id;
        this.location = location;
        this.priceModifyer = priceModifier;
        this.moneyInCashRegister = moneyInCashRegister;
        this.inventory = inventory;
    }

    public BookStore() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPriceModifier() {
        return priceModifyer;
    }

    public void setPriceModifier(Double priceModifier) {
        this.priceModifyer = priceModifier;
    }

    public Double getMoneyInCashRegister() {
        return moneyInCashRegister;
    }

    public void setMoneyInCashRegister(Double moneyInCashRegister) {
        this.moneyInCashRegister = moneyInCashRegister;
    }

    public Map<Book, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Book, Integer> inventory) {
        this.inventory = inventory;
    }

}
