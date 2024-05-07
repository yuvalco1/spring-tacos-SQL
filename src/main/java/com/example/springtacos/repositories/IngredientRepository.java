package com.example.springtacos.repositories;

import com.example.springtacos.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    // @Query("select o from Ingredient o where o.name = ?1") // for SQL database
    Ingredient findByName(String name);


}
