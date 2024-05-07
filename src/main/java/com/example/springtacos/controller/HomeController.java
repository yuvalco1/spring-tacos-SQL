package com.example.springtacos.controller;

import com.example.springtacos.model.Ingredient;
import com.example.springtacos.model.Ingredient.Type;
import com.example.springtacos.model.Taco;
import com.example.springtacos.model.TacoOrder;
import com.example.springtacos.repositories.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class HomeController {

//    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
//    @ResponseBody
//    public String home() {
//        Ingredient ingredient1 = new Ingredient("Tacos", "Flour", Ingredient.Type.WRAP);
//        Ingredient ingredient2 = new Ingredient("Tacos", "Corn", Ingredient.Type.PROTEIN);
//        Ingredient ingredient3 = new Ingredient("Tacos", "Chicken", Ingredient.Type.PROTEIN);
//        List<Ingredient> ingredients = List.of(ingredient1, ingredient2, ingredient3);
//        Taco taco = new Taco();
//        taco.setName("Tacos");
//        taco.setIngredients(ingredients);
//        return (taco.toString());

// Basic Spring Boot application with a single controller and a single view.
//    @GetMapping
//    public String showDesignForm() {
//        return "design";
//    }

    @Autowired
    private IngredientRepository ingredientRepo;


    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };}

    // passing a model to the view using Thymeleaf.
    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(@Valid Taco taco1, Errors errors, @ModelAttribute TacoOrder order) {
        if (errors.hasErrors()) {
            return "/design";
        }
        order.getTacos().add(taco1);
        log.info("Processing taco: {}", taco1);
        //return "we created taco with name:" + taco1.getName() + " and ingredients: " + taco1.getIngredients();
        return "redirect:/orders/current";
    }

    @ModelAttribute
    public Taco addTacoToModel() {
        return new Taco();
    }


    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredientList = (List) ingredientRepo.findAll();
        Type[] types = Type.values();
        for (Type type : types) {
            Iterable<Ingredient> ingredientsByType = filterByType(ingredientList, type);
            model.addAttribute(type.toString().toLowerCase(), ingredientsByType);
        }
    }

}


