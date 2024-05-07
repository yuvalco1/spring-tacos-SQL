package com.example.springtacos.controller;

import com.example.springtacos.model.TacoOrder;
import com.example.springtacos.repositories.TacoOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private TacoOrderRepository orderRepository;



    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping // for base address /orders ; can do for specific path too i.e. @PostMapping("/current")
    public String processOrder(@ModelAttribute TacoOrder tacoOrder, SessionStatus sessionStatus) {
        //need to add order processing logic
        orderRepository.save(tacoOrder);
        log.info("Order submitted: " + tacoOrder);
        sessionStatus.setComplete(); //mark session as complete so order doesn't stay in session
        return "redirect:/";//redirect to home page
    }


}



