package com.esen.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import lombok.Data;
import java.util.Map;


@Entity
@Data
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String location;
    private Double priceModifyer;
    private Double moneyInCashRegister;
    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnore
    private Map<Book, Integer> inventory;

    public BookStore() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPriceModifier() {
        return priceModifyer;
    }

    public void setPriceModifier(Double priceModifier) {
        this.priceModifyer = priceModifier;
    }

}
