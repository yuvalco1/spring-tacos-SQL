package com.example.springtacos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
// @Entity // this is for SQL database
public class Taco {

    // @Id // this is for SQL database
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // For SQL database
    // private Long id;// needed only for SQL database

    @NotBlank (message = "Name cannot be blank")
    private String name;

    @NotNull
    // @ManyToMany // for SQL database
    @Size(min = 1, message = "You must choose at least one ingredient")
    private List<Ingredient> ingredients;
}
