package com.example.springtacos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // This annotation is used to generate getters and setters for all of the fields in the class (Lombok annotation).
@Entity // This annotation is used to tell Spring that this class is an entity.
@AllArgsConstructor // This annotation is used to generate a constructor that takes all of the fields as arguments.
@NoArgsConstructor // This annotation is used to generate a constructor that takes no arguments.
public class Ingredient {
    @Id
    private String id;
    private String name;
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}