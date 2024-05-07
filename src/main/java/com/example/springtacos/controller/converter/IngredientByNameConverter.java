package com.example.springtacos.controller.converter;

import com.example.springtacos.model.Ingredient;
import com.example.springtacos.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class IngredientByNameConverter implements Converter<String, Ingredient> {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public Ingredient convert(String name) {
        return ingredientRepository.findByName(name);
    }

}
