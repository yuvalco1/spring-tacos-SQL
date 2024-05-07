package com.example.springtacos.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
// @Entity // this is for SQL database
@Document
public class TacoOrder {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // For SQL database
    private String id;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    // @OneToMany(cascade = CascadeType.ALL) // for SQL database
    // @JoinColumn (name = "taco_order_id") // for SQL database
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}