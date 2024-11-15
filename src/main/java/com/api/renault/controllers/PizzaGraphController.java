package com.api.renault.controllers;

import com.api.renault.models.PizzaGraphModel;
import com.api.renault.repository.PizzaGraphRepository;
import com.api.renault.responses.ErrorResponse;
import com.api.renault.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/v1/renault/graphs/pizza")

public class PizzaGraphController {
    @Autowired
    PizzaGraphRepository pizzaGraphRepository;

    @GetMapping
    public ResponseEntity<Object> getPizzaGraph() {
        try {
            return SuccessResponse.success200(pizzaGraphRepository.findAll());
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }

    @PostMapping
    public ResponseEntity<Object> postPizzaGraph(@RequestBody PizzaGraphModel pizzaGraphModel) {
        try {
            pizzaGraphRepository.save(pizzaGraphModel);
            return SuccessResponse.success200(pizzaGraphModel);
        } catch (Exception e) {
            return ErrorResponse.error500(e);
        }
    }
}