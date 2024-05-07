package com.example.springtacos.model;

//import jakarta.persistence.Entity; // This is for SQL database
//import jakarta.persistence.Id; // This is for SQL database
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id; // This is for MongoDB database
import org.springframework.data.mongodb.core.mapping.Document;

@Data // This annotation is used to generate getters and setters for all of the fields in the class (Lombok annotation).
// @Entity // This annotation is used to tell Spring that this class is an entity. this is for SQL database.
@Document // This annotation is used to tell Spring that this class is a document. this is for MongoDB database.
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